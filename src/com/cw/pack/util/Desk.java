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
import java.awt.GraphicsConfiguration;
import java.io.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
public class Desk extends Applet
{
 public BranchGroup createDesk()
 {
  BranchGroup rootGroup=new BranchGroup();
  BoundingSphere bounds=new BoundingSphere(new Point3d(0.0,0.0,0.0),100.0);
  Color3f bgColor=new Color3f(1.0f,1.0f,1.0f);
  Background bg=new Background(bgColor);
  bg.setApplicationBounds(bounds);
  rootGroup.addChild(bg);
  
  Color3f lightColor=new Color3f(1.0f,1.0f,1.0f);
  Vector3f vec=new Vector3f(0.0f,0.0f,-1.0f);
  DirectionalLight light=new DirectionalLight(lightColor,vec);
  light.setInfluencingBounds(bounds);
  rootGroup.addChild(light);
  
  PointLight pointLight=new PointLight();
  pointLight.setColor(lightColor);
  pointLight.setInfluencingBounds(bounds); 
  pointLight.setPosition(new Point3f(0.5f,0.1f,-0.6f));
  Transform3D tran=new Transform3D();
  tran.setRotation(new Quat4f(0.4f,1.0f,0.0f,1.57f));
  tran.setScale(0.7f);
  tran.setTranslation(new Vector3d(0.0f,0.6f,0.0f));
  TransformGroup transRoot=new TransformGroup(tran);
  transRoot.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
  transRoot.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
  tran=new Transform3D();
  tran.setTranslation(new Vector3d(0.0f,-0.3f,0.0f));
  TransformGroup trans1=new TransformGroup(tran);
  Appearance app=new Appearance();
  Material mat=new Material();
  mat.setDiffuseColor(1.0f,1.0f,0.0f);
  String fileName="1.jpg";
  String strPath=System.getProperty("user.dir")   +   java.io.File.separator+   fileName; ;
  TextureLoader texLoader1 = new TextureLoader( strPath, this);
  app.setTexture(texLoader1.getTexture());
  app.setMaterial(mat);
  Box box=new Box(0.8f,0.05f,0.7f,Box.GENERATE_NORMALS|Box.GENERATE_TEXTURE_COORDS,app);
  trans1.addChild(box);
  transRoot.addChild(trans1);
  transRoot.addChild(pointLight);
  
  tran=new Transform3D();
  tran.setTranslation(new Vector3d(0.3f,-1.0f,-0.3f));
  TransformGroup trans2=new TransformGroup(tran);
  box=new Box(0.1f,0.7f,0.1f,Box.GENERATE_NORMALS|Box.GENERATE_TEXTURE_COORDS,app);
  trans2.addChild(box);
  transRoot.addChild(trans2);
  
  tran=new Transform3D();
  tran.setTranslation(new Vector3d(-0.3f,-1.0f,0.3f));
  TransformGroup trans3=new TransformGroup(tran);
  box=new Box(0.1f,0.7f,0.1f,Box.GENERATE_NORMALS|Box.GENERATE_TEXTURE_COORDS,app);
  trans3.addChild(box);
  transRoot.addChild(trans3);
  
  tran=new Transform3D();
  tran.setTranslation(new Vector3d(0.3f,-1.0f,0.3f));
  TransformGroup trans4=new TransformGroup(tran);
  box=new Box(0.1f,0.7f,0.1f,Box.GENERATE_NORMALS|Box.GENERATE_TEXTURE_COORDS,app);
  trans4.addChild(box);
  transRoot.addChild(trans4);
  
  tran=new Transform3D();
  tran.setTranslation(new Vector3d(-0.3f,-1.0f,-0.3f));
  TransformGroup trans5=new TransformGroup(tran);
  box=new Box(0.1f,0.7f,0.1f,Box.GENERATE_NORMALS|Box.GENERATE_TEXTURE_COORDS,app);
  trans5.addChild(box);
  transRoot.addChild(trans5); 
  rootGroup.addChild(transRoot);
  
     MouseRotate behavior = new MouseRotate();
       behavior.setTransformGroup(transRoot);
     behavior.setSchedulingBounds(bounds);
     rootGroup.addChild(behavior);
     MouseZoom behavior2 = new MouseZoom();
       behavior2.setTransformGroup(transRoot);
     behavior2.setSchedulingBounds(bounds);
     rootGroup.addChild(behavior2);
     MouseTranslate behavior3 = new MouseTranslate();
       behavior3.setTransformGroup(transRoot);
     behavior3.setSchedulingBounds(bounds);
     rootGroup.addChild(behavior3);
  rootGroup.compile();
  return rootGroup;
 }
 public Desk()
 {
        setLayout(new BorderLayout());
        GraphicsConfiguration gc =
            SimpleUniverse.getPreferredConfiguration();
            Canvas3D c = new Canvas3D(gc);
        add("Center", c);
        BranchGroup scene = createDesk();
        SimpleUniverse u = new SimpleUniverse(c);
        u.getViewingPlatform().setNominalViewingTransform();
        u.addBranchGraph(scene);
 }
 public static void main(String[] strs)
 {
  new MainFrame(new Desk(),600,600);
 }
}