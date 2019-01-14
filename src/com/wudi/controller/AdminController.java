package com.wudi.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wudi.interceptor.AdminInterceptor;
import com.wudi.model.admin.NavsModel;

/**
 * 
 * @ClassName: AdminController
 * @Description: TODO 后台管理页面跳转管理类
 * @author xiao
 * @date 2018年10月29日下午4:08:09
 *
 */
@Before(AdminInterceptor.class)
public class AdminController extends Controller {
	@Clear(AdminInterceptor.class)
	public void login() {
		String username=getPara("username");
		String password=getPara("password");
		//判断用户名和密码是否正确
		if("1".equals(username)) {
			
		}else {
			
			render("login/login.html");
		}
		//如果不正确，就提示什么不正确？
		//如果正确，就正常显示系统页面
		
	}
	/**
	 * 
	 * @Title: index @Description:后台管理默认到达页面 @param 参数 @return void 返回类型 @throws
	 */
	public void index() {
		render("index.html");
	}
	public void main() {
		render("main.html");
	}

	/**
	 * 
	 * @Title: getnavs @Description: 获取主页面左侧菜单数据 @param 参数 @return void 返回类型 @throws
	 */
	public void getnavs() {
		Object object = NavsModel.getListForLeft();
		renderJson(object);
	}

	/**
	 * 显示菜单列表
	 */
	public void navsinfo() {
		render("sys/navsinfo.html");
	}

	/**
	 * 
	 * @Title: getnavs @Description: 获取侧菜单数据列表 @param 参数 @return void 返回类型 @throws
	 */
	public void getNavsList() {
		// 获取页面查询的关键字
		String key = getPara("key");
		int limit=getParaToInt("limit");
		int page=getParaToInt("page");
		Page<NavsModel> list = NavsModel.getList(page, limit, key);
		setAttr("code", 0);
		setAttr("msg", "你好！");
		setAttr("count", list.getTotalRow());
		setAttr("data", list.getList());
		renderJson();
	}

	/**
	 * 打开菜单添加页面
	 */
	public void openNavsAdd() {
		render("sys/navsAdd.html");
	}

	/**
	 * 添加保存菜单信息
	 */
	public void saveNavs() {
		String title = getPara("title");
		String href = getPara("href");
		String icon = "&#xe630;";
		String fid = getPara("fid");
		boolean result = NavsModel.saveModel(title, href, icon, fid);
		setAttr("result", result);
		renderJson();

	}

	/**
	 * TODO:根据id查找信息数据
	 */
	public void getModeListById() {
		String id = getPara("id");
		NavsModel m = NavsModel.getModeById(id);
		List<NavsModel> ml = NavsModel.getModeListByFid("-1");
		setAttr("m", m);// 找数据去更新
		setAttr("ml", ml);// 父节点列表
		renderJson();
	}

	/**
	 * TODO:根据fid查找信息数据
	 */
	public void getModeByFId() {
		List<NavsModel> ml = NavsModel.getModeListByFid("-1");
		setAttr("ml", ml);// 找数据去更新
		renderJson();
	}

	/**
	 * 打开菜单修改页面
	 */
	public void openNavsEdit() {
		// 接收页面数据
		String id = getPara("id");
		setAttr("id", id);
		renderFreeMarker("sys/navsEdit.html");
	}

	/**
	 * 更新保存菜单信息
	 */
	public void updatenavs() {
		String id = getPara("id");
		String title = getPara("title");
		String href = getPara("href");
		String icon = "&#xe630;";
		String fid = getPara("fid");
		boolean result = NavsModel.updateModel(id, title, href, icon, fid);
		setAttr("result", result);
		renderJson();

	}
	
	/**
	 * 打开更新信息页面
	 */
	public void opencaip() {
		// 接收页面数据
		String id = getPara("id");
		setAttr("id", id);
		render("sys/navsEdit.html");
	}
	
}