/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cw.pack.util;

/**
 *
 * @author Administrator
 */
import java.applet.Applet; 

import java.awt.BorderLayout; 

import java.awt.Frame; 

import javax.media.j3d.BoundingSphere; 

import javax.media.j3d.BranchGroup; 

import javax.media.j3d.Canvas3D; 

import javax.media.j3d.Geometry; 

import javax.media.j3d.GeometryArray; 

import javax.media.j3d.IndexedLineArray; 

import javax.media.j3d.Shape3D; 

import javax.media.j3d.TransformGroup; 

import javax.vecmath.Point3f; 

import com.sun.j3d.utils.applet.MainFrame; 

import com.sun.j3d.utils.behaviors.mouse.MouseRotate; 

import com.sun.j3d.utils.geometry.ColorCube; 

import com.sun.j3d.utils.universe.SimpleUniverse; 

// MouseRotateApp renders a single, interactively rotatable cube. 

public class MouseRotateApp extends Applet { 

public BranchGroup createSceneGraph() { 

// Create the root of the branch graph 

BranchGroup objRoot = new BranchGroup(); 

TransformGroup objRotate = new TransformGroup(); 

objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); 

objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ); 

objRoot.addChild(objRotate); 

objRotate.addChild(new ColorCube(0.4)); 

objRoot.addChild(new Axis()); 

MouseRotate myMouseRotate = new MouseRotate(); 

myMouseRotate.setTransformGroup(objRotate); 

myMouseRotate.setSchedulingBounds(new BoundingSphere()); 

objRoot.addChild(myMouseRotate); 

// Let Java 3D perform optimizations on this scene graph. 

objRoot.compile(); 

return objRoot; 

} // end of CreateSceneGraph method of MouseRotateApp 

// Create a simple scene and attach it to the virtual universe 

public MouseRotateApp() { 

setLayout(new BorderLayout()); 

Canvas3D canvas3D = new Canvas3D(null); 

add("Center", canvas3D); 

BranchGroup scene = createSceneGraph(); 

// SimpleUniverse is a Convenience Utility class 

SimpleUniverse simpleU = new SimpleUniverse(canvas3D); 

// This will move the ViewPlatform back a bit so the 

// objects in the scene can be viewed. 

simpleU.getViewingPlatform().setNominalViewingTransform(); 

simpleU.addBranchGraph(scene); 

} // end of MouseRotateApp (constructor) 

// The following allows this to be run as an application 

// as well as an applet 

public static void main(String[] args) { 

System.out 

.print("MouseRotateApp.java \n- a demonstration of using the MouseRotate "); 

System.out 

.println("utility behavior class to provide interaction in a Java 3D scene."); 

System.out 

.println("Hold the mouse button while moving the mouse to make the cube rotate."); 

System.out 

.println("This is a simple example progam from The Java 3D API Tutorial."); 

System.out.println("The Java 3D Tutorial is available on the web at:"); 

System.out.println("http://www.sun.com/desktop/java3d/collateral"); 

Frame frame = new MainFrame(new MouseRotateApp(), 256, 256); 

} // end of main (method of MouseRotateApp) 

} // end of class MouseRotateApp 

/* 

* Getting Started with the Java 3D API written in Java 3D 

* 

* This program demonstrates: 1. writing a visual object class In this program, 

* Axis class defines a visual object This particular class extends Shape3D See 

* the text for a discussion. 2. Using LineArray to draw 3D lines. 

*/ 

class Axis extends Shape3D { 

//////////////////////////////////////////// 

// 

// create axis visual object 

// 

public Axis() { 

this.setGeometry(createGeometry()); 

} 

private Geometry createGeometry() { 

// create line for X axis 

IndexedLineArray axisLines = new IndexedLineArray(18, 

GeometryArray.COORDINATES, 30); 

axisLines.setCoordinate(0, new Point3f(-1.0f, 0.0f, 0.0f)); 

axisLines.setCoordinate(1, new Point3f(1.0f, 0.0f, 0.0f)); 

axisLines.setCoordinate(2, new Point3f(0.9f, 0.1f, 0.1f)); 

axisLines.setCoordinate(3, new Point3f(0.9f, -0.1f, 0.1f)); 

axisLines.setCoordinate(4, new Point3f(0.9f, 0.1f, -0.1f)); 

axisLines.setCoordinate(5, new Point3f(0.9f, -0.1f, -0.1f)); 

axisLines.setCoordinate(6, new Point3f(0.0f, -1.0f, 0.0f)); 

axisLines.setCoordinate(7, new Point3f(0.0f, 1.0f, 0.0f)); 

axisLines.setCoordinate(8, new Point3f(0.1f, 0.9f, 0.1f)); 

axisLines.setCoordinate(9, new Point3f(-0.1f, 0.9f, 0.1f)); 

axisLines.setCoordinate(10, new Point3f(0.1f, 0.9f, -0.1f)); 

axisLines.setCoordinate(11, new Point3f(-0.1f, 0.9f, -0.1f)); 

axisLines.setCoordinate(12, new Point3f(0.0f, 0.0f, -1.0f)); 

axisLines.setCoordinate(13, new Point3f(0.0f, 0.0f, 1.0f)); 

axisLines.setCoordinate(14, new Point3f(0.1f, 0.1f, 0.9f)); 

axisLines.setCoordinate(15, new Point3f(-0.1f, 0.1f, 0.9f)); 

axisLines.setCoordinate(16, new Point3f(0.1f, -0.1f, 0.9f)); 

axisLines.setCoordinate(17, new Point3f(-0.1f, -0.1f, 0.9f)); 

axisLines.setCoordinateIndex(0, 0); 

axisLines.setCoordinateIndex(1, 1); 

axisLines.setCoordinateIndex(2, 2); 

axisLines.setCoordinateIndex(3, 1); 

axisLines.setCoordinateIndex(4, 3); 

axisLines.setCoordinateIndex(5, 1); 

axisLines.setCoordinateIndex(6, 4); 

axisLines.setCoordinateIndex(7, 1); 

axisLines.setCoordinateIndex(8, 5); 

axisLines.setCoordinateIndex(9, 1); 

axisLines.setCoordinateIndex(10, 6); 

axisLines.setCoordinateIndex(11, 7); 

axisLines.setCoordinateIndex(12, 8); 

axisLines.setCoordinateIndex(13, 7); 

axisLines.setCoordinateIndex(14, 9); 

axisLines.setCoordinateIndex(15, 7); 

axisLines.setCoordinateIndex(16, 10); 

axisLines.setCoordinateIndex(17, 7); 

axisLines.setCoordinateIndex(18, 11); 

axisLines.setCoordinateIndex(19, 7); 

axisLines.setCoordinateIndex(20, 12); 

axisLines.setCoordinateIndex(21, 13); 

axisLines.setCoordinateIndex(22, 14); 

axisLines.setCoordinateIndex(23, 13); 

axisLines.setCoordinateIndex(24, 15); 

axisLines.setCoordinateIndex(25, 13); 

axisLines.setCoordinateIndex(26, 16); 

axisLines.setCoordinateIndex(27, 13); 

axisLines.setCoordinateIndex(28, 17); 

axisLines.setCoordinateIndex(29, 13); 

return axisLines; 

} // end of Axis createGeometry() 

} // end of class Axis