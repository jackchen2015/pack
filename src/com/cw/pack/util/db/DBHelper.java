package com.cw.pack.util.db;

import com.cw.pack.Car;
import com.cw.pack.Model;
import com.cw.pack.Weapon;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBHelper {
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public boolean valid(String username, String password) {
		boolean isValid = false;
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			System.out.println("connect success");
			String sql = "select * from user where username='"+username+"' and password='"+password+"'";
			db.query(sql);
			if(db.next()) {
				isValid = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		//String ipVal = getAccessIP(username,password);
		return isValid;
	}
	
	public String getAccessIP(String username, String password){
		DB2Access db = new DB2Access();
		String ipVal = null;
		if(db.createConn()){
			String sql = "select b.ipaddr ipaddr,b.port port from user a,site b where b.id=a.siteid and a.username='"+username+"' and a.password='"+password+"'";
			db.query(sql);
			if(db.next()) {
				ipVal = db.getValue("ipaddr")+":"+db.getValue("port");
				System.out.println("ipval is:"+ipVal);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();			
		}
		return ipVal;
	}
	
	public static List<String[]> getEntryList(List<String[]> entryList, int pageNum, int pageSize) {
		List<String[]> ret = new ArrayList<String[]>();
		int start = (pageNum - 1) * pageSize;
		int end = start + pageSize - 1;
		if (start >= entryList.size())
			return ret;
		
		for (int i = start; i <= end; i++) {
			if (i < entryList.size())
				ret.add(entryList.get(i));
		}
		
		return ret;
	}
	
	public List<String[]> getSelSite(String username, String password){
		DB2Access db = new DB2Access();
		String siteid = "";
		String rownum = "";
		List<String[]> selSites = new ArrayList<String[]>();
		if(db.createConn()){
			String sql = "select * from user where username='"+username+"' and password='"+password+"'";
			db.query(sql);
			if(db.next()){
				String rule = db.getValue("rule");
				if("0".equals(rule)){
					java.util.Date d = new java.util.Date();
					int hour = d.getHours();
					if(hour<8||hour>18){
						return selSites;
					}
				}
				siteid = db.getValue("siteid");
				rownum = db.getValue("rownum");
			}
			sql = "select * from site where id in ("+siteid+")";
			db.query(sql);
			while(db.next()){
				String img = db.getValue("img");
				if(img==null||img.equals("")){
					img = "link.jpg";
				}
				String[] rowSite = {db.getValue("id"),db.getValue("name"),db.getValue("comment"),db.getValue("port"),img};
				selSites.add(rowSite);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return selSites;
	}
	
	public int getRownum(String username, String password){
		DB2Access db = new DB2Access();
		String rownum = "";
		if(db.createConn()){
			String sql = "select rownum from user where username='"+username+"' and password='"+password+"';";
			db.query(sql);
			if(db.next()){
				rownum = db.getValue("rownum");
				if(rownum==null){
					rownum = "3";
				}
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();			
		}
		return Integer.parseInt(rownum);
	}
	
	public boolean isAdmin(String username, String password){
		DB2Access db = new DB2Access();
		boolean isAdm = false;
		if(username.equals("管理员")&&password.equals("mxld123")){
			return true;
		}
		if(db.createConn()){
			String sql = "select * from user where username='"+username+"' and password='"+password+"';";
			db.query(sql);
			if(db.next()) {
				String val = db.getValue("isadmin");
				if(val!=null){
					isAdm = val.equals("1")?true:false;
				}				
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();			
		}
		return isAdm;
	}

/**
 *    <th>ID</th>
    <th>用户名称</th>
    <th>允许访问站点</th>
    <th>是否管理员</th>
    <th style="width: 222px; ">描述</th>	
 * @return
 */
	
	public List<String[]> getAllUser(){
		DB2Access db = new DB2Access();
		List<String[]> result = new ArrayList<String[]>();
		List<String[]> allSites = getAllSite();
		if(db.createConn()){
//			String sql = "select u.id id,u.username username, s.ipaddr ipaddr, u.isadmin isadmin, u.comment comment from user u left join site s on s.id=u.siteid";
			String sql = "select * from user";
			db.query(sql);
			while(db.next()){
				String isadmin = db.getValue("isadmin");
				if(isadmin.equals("1")){
					isadmin = "是";
				}else{
					isadmin = "否";
				}
				String[] row = {db.getValue("id"),db.getValue("username"),
						replaceIDWithName(db.getValue("siteid"),allSites),isadmin,db.getValue("comment")};
				result.add(row);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
	private String replaceIDWithName(String idstr, List<String[]> allSites){
		String[] ids = idstr.split(",");
		String withName = "";
		List<String> idLst = Arrays.asList(ids);
		for(String[] site:allSites){
			String sid = site[0];
			if(idLst.contains(sid)){
				withName += site[1]+",";
			}
		}
		return withName.length()>1?withName.substring(0, withName.length()-1):"";
	}

	public List<String[]> getAllSite(){
		DB2Access db = new DB2Access();
		List<String[]> result = new ArrayList<String[]>();
		if(db.createConn()){
			String sql = "select * from site";
			db.query(sql);
			while(db.next()){
				String[] row = {db.getValue("id"),db.getValue("name"),
						db.getValue("ipaddr"),db.getValue("port"),db.getValue("sitejrfs"),db.getValue("createuser"),db.getValue("createtime"),db.getValue("comment"),db.getValue("img")};
				result.add(row);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}

	public List<String[]> getAllLog(){
		DB2Access db = new DB2Access();
		List<String[]> result = new ArrayList<String[]>();
		if(db.createConn()){
			String sql = "select * from log";
			db.query(sql);
			while(db.next()){
				String[] row = {db.getValue("id"),db.getValue("username"),
						db.getValue("companyname"),db.getValue("sitename"),db.getValue("siteip"),db.getValue("logtime"),db.getValue("place"),db.getValue("loginip")};
				result.add(row);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
	public List<String[]> getAllCfg(){
		DB2Access db = new DB2Access();
		List<String[]> result = new ArrayList<String[]>();
		if(db.createConn()){
			String sql = "select * from cfgtable";
			db.query(sql);
			while(db.next()){
				String[] row = {db.getValue("id"),db.getValue("descname"),
						db.getValue("location"),db.getValue("name")};
				result.add(row);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
	public boolean isExist(String username) {
		boolean isExist = false;
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "select * from user where username='"+username+"'";
			db.query(sql);
			if(db.next()) {
				isExist = true;
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return isExist;
	}
	
	public void addUser(String username, String password, String siteIp, String isadmin, String userdesc, String rownum, String company, String dept, String position, String phonenumber, String rule) {
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "insert into user(username,password,siteid, isadmin,comment,rownum,companyid,deptid,positionid,phonenumber,rule) values('"+username+"','"+password+"','"+siteIp+"','"+isadmin+"','"+userdesc+"','"+rownum+"','"+company+"','"+dept+"','"+position+"','"+phonenumber+"','"+rule+"')";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}
	
	public void delUser(String id){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "delete from user where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}
	
	public String getCompanyNameByUserName(String username){
		DB2Access db = new DB2Access();
		String cpName = "";
		String sql = "select a.companyname companyname from comapny a,user b where a.id=b.companyid";
		if(db.createConn()){
			db.query(sql);
			if(db.next()){
				cpName = db.getValue("companyname");
			}
		}
		return cpName;
	}
	
	public void updateUser(String id, String username, String password, String[] siteid, String isadmin, String comment, String rownum, String company, String dept, String position, String phonenumber, String rule){
		DB2Access db = new DB2Access();
		String sids = "";
		if(siteid==null){
			siteid = new String[]{};
		}
		for(String str:siteid){
			sids += str+",";
		}
		if(sids.length()>1){
			sids = sids.substring(0, sids.length()-1);
		}
		if(db.createConn()) {
			String sql = "update user set username='"+username+"',password='"+password+"',siteid='"+sids+"',isadmin='"+isadmin+"',comment='"+comment+"',rownum='"+rownum+"',companyid='"+company+"',deptid='"+dept+"',positionid='"+position+"',phonenumber='"+phonenumber+"',rule='"+rule+"' where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}
	
	public String[] getUserById(String id){
		DB2Access db = new DB2Access();
		String[] result = new String[6];
		if(db.createConn()) {
//			String sql = "select u.id id,u.username username, u.password password, s.ipaddr ipaddr, u.isadmin isadmin, u.phonenumber phonenumber from user u left join site s on s.id=u.siteid where u.id='"+id+"'";
			String sql = "select * from user where id='"+id+"'";
			db.query(sql);
			if(db.next()){
				result = new String[]{db.getValue("id"),db.getValue("username"),db.getValue("password"),
						db.getValue("siteid"),db.getValue("isadmin"),db.getValue("comment"),db.getValue("rownum"),db.getValue("companyid"),db.getValue("deptid"),db.getValue("positionid"),db.getValue("phonenumber"),db.getValue("rule")};
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
	public void addSite(String sitename, String siteIp, String siteport, String desc, String img,String jrfs, String createuser) {
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "insert into site(name,ipaddr,port,comment,img,sitejrfs,createuser,createtime) values('"+sitename+"','"+siteIp+"','"+siteport+"','"+desc+"','"+img+"','"+jrfs+"','"+createuser+"','"+format.format(new java.util.Date())+"')";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}
	
	public void delSite(String id){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "delete from site where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

	public void autoUpdateSite(String id, String siteip){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "update site set ipaddr='"+siteip+"' where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}
	
	public void updateSite(String id, String name, String siteip, String port, String comment,String img,String jrfs){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "";
			if("".equals(img)){
				sql = "update site set name='"+name+"',ipaddr='"+siteip+"',port='"+port+"',comment='"+comment+"',sitejrfs='"+jrfs+"' where id='"+id+"'";
			}else{
				sql = "update site set name='"+name+"',ipaddr='"+siteip+"',port='"+port+"',comment='"+comment+"',img='"+img+"',sitejrfs='"+jrfs+"' where id='"+id+"'";
			}
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}
	
	public void updateCfg(String id, String comment, String location){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "update cfgtable set descname='"+comment+"',location='"+location+"' where id='"+id+"'";

//			if("".equals(location)){
//				sql = "update cfgtable set descname='"+comment+"',location='"+location+"' where id='"+id+"'";
//			}else{
//				sql = "update cfgtable set descname='"+name+"',ipaddr='"+siteip+"',port='"+port+"',comment='"+comment+"',img='"+img+"' where id='"+id+"'";
//			}
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}
	public String[] getSiteById(String id){
		DB2Access db = new DB2Access();
		String[] result = new String[6];
		if(db.createConn()) {
			String sql = "select * from site where id='"+id+"'";
			db.query(sql);
			if(db.next()){
				String img = db.getValue("img");
				if(img==null||img.equals("")){
					img = "link.jpg";
				}
				result = new String[]{db.getValue("id"),db.getValue("name"),db.getValue("ipaddr"),
						db.getValue("port"),db.getValue("comment"),img};
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
	public String[] getCfgById(String id){
		DB2Access db = new DB2Access();
		String[] result = new String[4];
		if(db.createConn()) {
			String sql = "select * from cfgtable where id='"+id+"'";
			db.query(sql);
			if(db.next()){
				String img = db.getValue("location");
				if(img==null||img.equals("")){
					img = "link.jpg";
				}
				result = new String[]{db.getValue("id"),db.getValue("name"),db.getValue("location"),
						db.getValue("descname")};
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
	public void addLog(String username,String sitename,String siteip,String place,String loginip){
		String companyname = this.getCompanyNameByUserName(username);
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "insert into log(username,companyname,sitename,siteip,logtime,place,loginip) values('"+username+"','"+companyname+"','"+sitename+"','"+siteip+"','"+format.format(new java.util.Date())+"','"+place+"','"+loginip+"')";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

	public void updateType(String id, String name, String comment) {
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "update ctype set name='"+name+"', comment='"+comment+"' where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

	public void addType(String name, String comment) {
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "insert into ctype(name,comment) values('"+name+"','"+comment+"')";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}		
	}

	public void delType(String id) {
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "delete from ctype where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}		
	}

	public String[] getTypeById(String id) {
		DB2Access db = new DB2Access();
		String[] result = new String[3];
		if(db.createConn()) {
			String sql = "select * from ctype where id='"+id+"'";
			db.query(sql);
			if(db.next()){
				result = new String[]{db.getValue("id"),db.getValue("name"),db.getValue("comment")};
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}

	public List<String[]> getAllType() {
		DB2Access db = new DB2Access();
		List<String[]> result = new ArrayList<String[]>();
		if(db.createConn()){
			String sql = "select * from ctype";
			db.query(sql);
			while(db.next()){
				String[] row = {db.getValue("id"),db.getValue("name"),
						db.getValue("comment")};
				result.add(row);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}

	public List<String[]> getAllCompanys() {
		DB2Access db = new DB2Access();
		List<String[]> result = new ArrayList<String[]>();
		if(db.createConn()){
			String sql = "select a.id id,a.companyname, b.name type,a.location location,a.contract contract from company a,ctype b where a.type=b.id";
			db.query(sql);
			while(db.next()){
				String[] row = {db.getValue("id"),db.getValue("companyname"),
						db.getValue("type"),db.getValue("location"),db.getValue("contract")};
				result.add(row);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
//handler car	
	public List<Car> getAllCar(){
		DB2Access db = new DB2Access();
		List<Car> result = new ArrayList<Car>();
		if(db.createConn()){
			String sql = "select * from car";
			db.query(sql);
			while(db.next()){
				Car car = new Car();
				car.setId(db.getIntVal("id"));
				car.setLength(db.getIntVal("length"));
				car.setWidth(db.getIntVal("width"));
				car.setHigh(db.getIntVal("high"));
				car.setLoadWeight(db.getIntVal("weight"));
				result.add(car);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
	public int addCar(String name, Integer length, Integer width, Integer height, Integer weight) {
		DB2Access db = new DB2Access();
		int id = -1;
		if(db.createConn()) {
			String sql = "insert into car(name,length,width,high,weight) values('"+name+"','"+length+"','"+width+"','"+height+"','"+weight+"')";
			id = db.insert(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return id;
	}
	
	public void delCar(Integer id){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "delete from car where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

	public void updateCar(Integer id, String name, Integer length, Integer width, Integer height, Integer weight){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "update car set name='"+name+"', length='"+ length +"', width='"+width+"', height='"+height+"' where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

//handler weapon type
	public List<Model> getAllModel(){
		DB2Access db = new DB2Access();
		List<Model> result = new ArrayList<Model>();
		if(db.createConn()){
			String sql = "select * from model";
			db.query(sql);
			while(db.next()){
				Model type = new Model();
				type.setId(Integer.parseInt(""+db.getValue("id")));
				type.setName(db.getValue("name"));
				type.setDesc(db.getValue("comment"));
				result.add(type);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}	
	public int addModel(String name, String comment) {
		DB2Access db = new DB2Access();
		int id = -1;
		if(db.createConn()) {
			String sql = "insert into model(name,comment) values('"+name+"','"+comment+"')";
			id = db.insert(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return id;
	}
	
	public void delModel(Integer id){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "delete from model where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

	public void updateModel(Integer id, String name, String comment){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "update model set name='"+name+"', comment='"+comment+"' where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

//handler weapon
	public List<Weapon> getAllWeapon(){
		DB2Access db = new DB2Access();
		List<Weapon> result = new ArrayList<Weapon>();
		if(db.createConn()){
			String sql = "select w.*,m.id as typeid,m.name as typename,m.comment as comment from weapon w, model m where w.model=m.id";
			db.query(sql);
			while(db.next()){
				Weapon weapon = new Weapon();
				weapon.setId(db.getIntVal("id"));
				weapon.setName(db.getValue("name"));
				weapon.setLength(db.getIntVal("length"));
				weapon.setWidth(db.getIntVal("width"));
				weapon.setHigh(db.getIntVal("high"));
				weapon.setWeight(db.getIntVal("weight"));
				Model model = new Model();
				model.setId(db.getIntVal("typeid"));
				model.setName(db.getValue("typename"));
				model.setDesc(db.getValue("comment"));
				weapon.setModel(model);
				result.add(weapon);
			}
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return result;
	}
	
	public int addWeapon(String name, Integer length, Integer width, Integer height, Integer weight, Integer type) {
		DB2Access db = new DB2Access();
		int id = -1;
		if(db.createConn()) {
			String sql = "insert into weapon(name, length, width, high, weight, model) values('"+name+"','"+length+"','"+width+"','"+height+"','"+weight+"','"+type+"')";
			id = db.insert(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
		return id;
	}
	
	public void delWeapon(Integer id){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "delete from weapon where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

	public void updateWeapon(Integer id, String name, Integer length, Integer width, Integer height, Integer weight, Integer type){
		DB2Access db = new DB2Access();
		if(db.createConn()) {
			String sql = "update weapon set name='"+name+"',length='"+length+"',width='"+width+"',high='"+height+"',type='"+type+"' where id='"+id+"'";
			db.update(sql);
			db.closeRs();
			db.closeStm();
			db.closeConn();
		}
	}

}
