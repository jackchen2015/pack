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
import com.sun.j3d.utils.geometry.Box;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.DirectionalLight;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.universe.SimpleUniverse;
/**
 *
 *
 *  @version ： 1.1
 *  
 *  @author  ： 苏若年         <a href="mailto:DennisIT@163.com">发送邮件</a>
 *    
 *  @since   ： 1.0      创建时间:    2013-5-6 下午02:50:08
 *     
 *  TODO     : Java3D 各种三维形状展示
 *
 */
public class Java3DShape {
    public Java3DShape(){

        //构建空间 和物体

        // 创建一个虚拟空间
        SimpleUniverse universe = new  SimpleUniverse();
        // 创建一个用来包含对象的数据结构
        BranchGroup group = new BranchGroup();
        // 创建一个椎体并把它加入到group中
//          Cone cone=new Cone(.5f,1.0f,1,null) ;    //锥体
		  Box cone=new Box(.5f,.3f,.5f,null) ;    //锥体
        group.addChild(cone);

        //灯光构造
        Color3f light1Color = new Color3f(0.8f, 0.1f, 0.2f);
        // 设置光线的颜色
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        // 设置光线的作用范围
        Vector3f light1Direction  = new Vector3f(4.0f, -7.0f, -12.0f);
        // 设置光线的方向
        DirectionalLight light1= new DirectionalLight(light1Color, light1Direction);
          // 指定颜色和方向，产生单向光源
        light1.setInfluencingBounds(bounds);
        // 把光线的作用范围加入光源中
        group.addChild(light1);
        // 将光源加入group组
        // 安放观察点
        universe.getViewingPlatform().setNominalViewingTransform();
        // 把group加入到虚拟空间中
        universe.addBranchGraph(group);
    }

    public static void main(String[] args) {
        new Java3DShape();
    }
}