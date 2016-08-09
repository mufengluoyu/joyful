package com.joyful.controller.keywordrank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joyful.common.base.BaseController;
import com.joyful.common.page.PageHelper.Page;
import com.joyful.common.page.PageStrUtil;
import com.joyful.common.util.DateUtil;
import com.joyful.common.util.HttpURLUtil;
import com.joyful.common.util.SerialNo;
import com.joyful.common.util.StringUtil;
import com.joyful.common.util.excel.ImportExcel;
import com.joyful.entity.keywordrank.BaiduKeywordRankVo;
import com.joyful.entity.keywordrank.KeywordRankEntity;
import com.joyful.entity.keywordrank.KeywordTypeEnum;
import com.joyful.entity.keywordrank.ShenmaKeywordRankVo;
import com.joyful.service.keywordrank.IKeywordRankService;

@Controller
@RequestMapping("/keywordRankController")
public class KeywordRankController extends BaseController {
	
	@Autowired
	private IKeywordRankService keywordRankService;
	
	@RequestMapping(value="/keywordRankList" )  
    public String keywordRankList(HttpServletRequest request,Model model){
		String type = request.getParameter("type");
		String orderType = request.getParameter("orderType");
		String sendDateStart = request.getParameter("sendDateStart");
		String sendDateEnd = request.getParameter("sendDateEnd");
		
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		
		Date startTime = null;
		Date endTime = null;
		if(StringUtil.isNotEmpty(sendDateStart)){
			startTime = DateUtil.getDateFromString1(sendDateStart);
		}
		if(StringUtil.isNotEmpty(sendDateEnd)){
			//增加一天
			endTime =DateUtil.getRelativeDate(DateUtil.getDateFromString1(sendDateEnd), Calendar.DATE, 1);
		}
		
		KeywordRankEntity record = new KeywordRankEntity();
		if(StringUtil.isNotEmpty(type))
			record.setType(type);
		Page<KeywordRankEntity> page = keywordRankService.findKeywordRankEntity(record, startTime, endTime, orderType,pageNum,pageSize);
		
		model.addAttribute("page", page);
		model.addAttribute("pageStr", PageStrUtil.pageStr(page, ""));
		model.addAttribute("type", type);
		model.addAttribute("orderType", orderType);
		model.addAttribute("sendDateStart", sendDateStart);
		model.addAttribute("sendDateEnd", sendDateEnd);
		
		return "/keywordRank/keywordRankList";
	}
	
	@RequestMapping(value = "/importKeywordRank", method=RequestMethod.POST)  
    public String importKeywordRank( @RequestParam MultipartFile file, HttpServletRequest request,RedirectAttributes redirectAttributes){
		String basePath = HttpURLUtil.findRealBaseUrl(request);
		String type = request.getParameter("type");
		
		if(StringUtil.isNotEmpty(type)){
			try {
				int successNum = 0;
				
				StringBuilder failureMsg = new StringBuilder();
				ImportExcel ei = new ImportExcel(file, 0, 0);
				List<KeywordRankEntity> insertLists = new ArrayList<KeywordRankEntity>();
				if(KeywordTypeEnum.BAIDU.getIndex().equals(type)){
					List<BaiduKeywordRankVo> list = ei.getDataList(BaiduKeywordRankVo.class);
					double start  = System.currentTimeMillis() ; 
					for(BaiduKeywordRankVo baidu : list){
						KeywordRankEntity record = new KeywordRankEntity();
						record.setId(SerialNo.getUNID());
						record.setType(type);
						record.setKeyword(baidu.getKeyword());
						record.setExtensionPlan(baidu.getExtensionPlan());
						record.setExtensionUnit(baidu.getExtensionUnit());
						record.setSendDate(baidu.getSendDate());
						if(StringUtil.isNumeric(baidu.getShowQuantity()))
							record.setShowQuantity(new BigDecimal(baidu.getShowQuantity()));
						if(StringUtil.isNumeric(baidu.getClickQuantity()))
							record.setClickQuantity(new BigDecimal(baidu.getClickQuantity()));
						if(StringUtil.isNumeric(baidu.getConsumeQuantity()))
							record.setConsumeQuantity(new BigDecimal(baidu.getConsumeQuantity()));
						if(StringUtil.isNumeric(baidu.getClickRate()))
							record.setClickRate(baidu.getClickRate());
						if(StringUtil.isNumeric(baidu.getClickAveragePrice()))
							record.setClickAveragePrice(new BigDecimal(baidu.getClickAveragePrice()));
						if(StringUtil.isNumeric(baidu.getWebPageConversion()))
							record.setWebPageConversion(new BigDecimal(baidu.getWebPageConversion()));
						if(StringUtil.isNumeric(baidu.getMerchantBridgeConversion()))
							record.setMerchantBridgeConversion(new BigDecimal(baidu.getMerchantBridgeConversion()));
						if(StringUtil.isNumeric(baidu.getTelephoneConversion()))
							record.setTelephoneConversion(new BigDecimal(baidu.getTelephoneConversion()));
						if(StringUtil.isNumeric(baidu.getAverageOrder().trim()))
							record.setAverageOrder(new BigDecimal(baidu.getAverageOrder().trim()));
//						keywordRankService.keywordRankInsert(record);
						insertLists.add(record);
						successNum++;
					}
					double end = System.currentTimeMillis() ;
					 System.out.println("time is : " + (end - start));
				}else{
					List<ShenmaKeywordRankVo> list = ei.getDataList(ShenmaKeywordRankVo.class);
					for(ShenmaKeywordRankVo shenma : list){
						KeywordRankEntity record = new KeywordRankEntity();
						record.setId(SerialNo.getUNID());
						record.setType(type);
						record.setKeyword(shenma.getKeyword());
						record.setExtensionPlan(shenma.getExtensionPlan());
						record.setExtensionUnit(shenma.getExtensionUnit());
						record.setSendDate(shenma.getSendDate());
						record.setAccount(shenma.getAccount());
						if(StringUtil.isNumeric(shenma.getShowQuantity()))
							record.setShowQuantity(new BigDecimal(shenma.getShowQuantity()));
						if(StringUtil.isNumeric(shenma.getClickQuantity()))
							record.setClickQuantity(new BigDecimal(shenma.getClickQuantity()));
						if(StringUtil.isNumeric(shenma.getConsumeQuantity()))
							record.setConsumeQuantity(new BigDecimal(shenma.getConsumeQuantity()));
						if(StringUtil.isNumeric(shenma.getClickRate()))
							record.setClickRate(shenma.getClickRate());
						if(StringUtil.isNumeric(shenma.getClickAveragePrice()))
							record.setClickAveragePrice(new BigDecimal(shenma.getClickAveragePrice()));
						
//						keywordRankService.keywordRankInsert(record);
						insertLists.add(record);
						successNum++;
					}
				}
				if(insertLists != null && insertLists.size() > 0){
					double start1  = System.currentTimeMillis() ; 
					keywordRankService.keywordRankInserts(insertLists);
					double end1 = System.currentTimeMillis() ;
					System.out.println("time1 is : " + (end1 - start1));
				}
				addMessage(redirectAttributes, "已成功导入 "+successNum+" 条用户"+failureMsg);
				
			} catch (Exception e) {
				e.printStackTrace();
				addMessage(redirectAttributes, "导入用户失败！失败信息："+e.getMessage());
			}
		}else{
			addMessage(redirectAttributes, "导入用户失败！失败信息：类型不能为空！");
		}
		 
		return "redirect:"+basePath+"/keywordRankController/keywordRankList.do";
	} 
	
}
