package com.joyful.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joyful.common.page.PageHelper.Page;
import com.joyful.common.page.PageStrUtil;
import com.joyful.common.util.HttpURLUtil;
import com.joyful.common.util.SerialNo;
import com.joyful.common.util.excel.ImportExcel;
import com.joyful.entity.user.UserEntity;
import com.joyful.service.user.IUserService;


@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
    private IUserService userService;  
      
	@RequestMapping(value="/userList" )  
    public String toIndex(HttpServletRequest request,Model model){
		
    	List<UserEntity> userList = new ArrayList<UserEntity>();
    	for(int i = 0 ; i < 4 ; i++){
    		UserEntity user = new UserEntity();
    		user.setAge(12);
    		user.setUserName("xujingbin");
    		user.setPassword("22222222");
    		userList.add(user);
    	}
    	Page<UserEntity> page = new Page<UserEntity>(1, 10);
    	page.setResult(userList);
    	page.setTotal(4);
    	page.setPages(1);
    	page.setStartRow(0);
    	page.setEndRow(4);
    	model.addAttribute("pageStr",PageStrUtil.pageStr(page, ""));
    	model.addAttribute("page",page);
    	return "/user/xdemo";
    }
	
    //导入工作
    @RequestMapping(value = "/import", method=RequestMethod.POST)  
    public String importTest( @RequestParam MultipartFile file, HttpServletRequest request,RedirectAttributes redirectAttributes){
    	String basePath = HttpURLUtil.findRealBaseUrl(request);
		
		try {
			int successNum = 0;
			
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 0, 0);
			List<UserEntity> list = ei.getDataList(UserEntity.class);
			for(UserEntity user : list){
				user.setId(SerialNo.getUNID());
				userService.userInsert(user);
				successNum++;
			}
			
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条用户"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入用户失败！失败信息："+e.getMessage());
		}
		return "redirect:"+basePath+"/userController/userList.do";
    }
    
    /**
	 * 添加Flash消息
	 * @param message
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}
	
	@RequestMapping("/xdemo")
	public String xdemo(HttpServletRequest request,Model model) throws Exception{
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> mapTemp = new HashMap<String, Object>();
			mapTemp.put("id", i);
			mapTemp.put("name", "name"+1);
			mapTemp.put("num", i);
			
			list.add(mapTemp);
		}
		model.addAttribute("list", list);
//		if(1==1) throw new Exception("xxxxxxxxxxx");
		
    	return "/user/xdemo";
    }
	
}
