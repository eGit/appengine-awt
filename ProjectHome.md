appengine-awt is a pure java implementation of the java.awt and javax.imageio packages for use in the Google AppEngine environment.

The code is based mainly on the Apache Harmony and Apache Sanselan projects.

Currently this library provides enough functionality to transcode svg files to images using batik. [demo](http://pure-java-awt.appspot.com/)



**PLEASE KEEP IN MIND: THIS SOFTWARE IS EXPERIMENTAL**

That means that it will probably not work for you! You are welcome to try, but there will be no support provided at this time. If you would like to help with development, please do!

Some of the major limitations at this time:
  1. Text rendering is not supported
  1. Images are rendered without antialiasing
  1. Use requires changes to source code
  1. It is very slow