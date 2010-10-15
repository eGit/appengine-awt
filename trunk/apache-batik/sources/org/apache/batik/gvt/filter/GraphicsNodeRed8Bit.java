/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.apache.batik.gvt.filter;

import com.google.code.appengine.awt.AlphaComposite;
import com.google.code.appengine.awt.Graphics2D;
import com.google.code.appengine.awt.Rectangle;
import com.google.code.appengine.awt.RenderingHints;
import com.google.code.appengine.awt.geom.AffineTransform;
import com.google.code.appengine.awt.geom.Rectangle2D;
import com.google.code.appengine.awt.image.BufferedImage;
import com.google.code.appengine.awt.image.ColorModel;
import com.google.code.appengine.awt.image.SampleModel;
import com.google.code.appengine.awt.image.WritableRaster;

import org.apache.batik.ext.awt.image.GraphicsUtil;
import org.apache.batik.ext.awt.image.rendered.AbstractRed;
import org.apache.batik.ext.awt.image.rendered.AbstractTiledRed;
import org.apache.batik.ext.awt.image.rendered.CachableRed;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.util.Platform;

/**
 * This implementation of RenderableImage will render its input
 * GraphicsNode on demand for tiles.
 *
 * @author <a href="mailto:vincent.hardy@eng.sun.com">Vincent Hardy</a>
 * @version $Id: GraphicsNodeRed8Bit.java 713578 2008-11-13 00:28:21Z cam $
 */
public class GraphicsNodeRed8Bit extends AbstractRed {

    /**
     * GraphicsNode this image can render
     */
    private GraphicsNode node;

    private AffineTransform node2dev;

    private RenderingHints  hints;

    private boolean usePrimitivePaint;

    public GraphicsNodeRed8Bit(GraphicsNode node,
                               AffineTransform node2dev,
                               boolean usePrimitivePaint,
                               RenderingHints  hints) {
        super(); // We _must_ call init...

        this.node              = node;
        this.node2dev          = node2dev;
        this.hints             = hints;
        this.usePrimitivePaint = usePrimitivePaint;

        // Calculate my bounds by applying the affine transform to
        // my input data..

        AffineTransform at = node2dev;
        Rectangle2D bounds2D = node.getPrimitiveBounds();
        if (bounds2D == null) bounds2D = new Rectangle2D.Float(0,0,1,1);
        if (!usePrimitivePaint) {
            // When not using Primitive paint we return our bounds in
            // the nodes parent's user space.  This makes sense since
            // this is the space that we will draw our selves into
            // (since paint unlike primitivePaint incorporates the
            // transform from our user space to our parents user
            // space).
            AffineTransform nodeAt = node.getTransform();
            if (nodeAt != null) {
                at = (AffineTransform)at.clone();
                at.concatenate(nodeAt);
            }
        }
        Rectangle   bounds = at.createTransformedShape(bounds2D).getBounds();
        // System.out.println("Bounds: " + bounds);

        ColorModel cm = createColorModel();

        int defSz = AbstractTiledRed.getDefaultTileSize();

        // Make tile(0,0) fall on the closest intersection of defaultSz.
        int tgX = defSz*(int)Math.floor(bounds.x/defSz);
        int tgY = defSz*(int)Math.floor(bounds.y/defSz);

        int tw  = (bounds.x+bounds.width)-tgX;
        if (tw > defSz) tw = defSz;
        int th  = (bounds.y+bounds.height)-tgY;
        if (th > defSz) th = defSz;
        if ((tw <= 0) || (th <= 0)) {
            tw = 1;
            th = 1;
        }

        // fix my sample model so it makes sense given my size.
        SampleModel sm = cm.createCompatibleSampleModel(tw, th);

        // Finish initializing our base class...
        init((CachableRed)null, bounds, cm, sm, tgX, tgY, null);
    }

    public WritableRaster copyData(WritableRaster wr) {
        genRect(wr);
        return wr;
    }

    public void genRect(WritableRaster wr) {
        // System.out.println("  Rect: " + wr.getBounds());
        BufferedImage offScreen
            = new BufferedImage(cm, 
                                wr.createWritableTranslatedChild(0,0),
                                cm.isAlphaPremultiplied(),
                                null);

        Graphics2D g = GraphicsUtil.createGraphics(offScreen, hints);
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(0, 0, wr.getWidth(), wr.getHeight());
        g.setComposite(AlphaComposite.SrcOver);
        g.translate(-wr.getMinX(), -wr.getMinY());

        // Set transform
        g.transform(node2dev);


        // Invoke primitive paint.
        if (usePrimitivePaint) {
            node.primitivePaint(g);
        }
        else {
            node.paint (g);
        }

        g.dispose();
    }

    public ColorModel createColorModel() {
        if (Platform.isOSX)
            return GraphicsUtil.sRGB_Pre;
        return GraphicsUtil.sRGB_Unpre;
    }
}
