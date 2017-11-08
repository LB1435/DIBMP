package cn.mldn.dibmp.web.action.back;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.service.IMemberService;
import cn.mldn.dibmp.service.IStorageApplyDetailsService;
import cn.mldn.dibmp.service.IStorageApplyService;
import cn.mldn.dibmp.service.IStorageRecordService;
import cn.mldn.dibmp.vo.Dept;
import cn.mldn.dibmp.vo.Level;
import cn.mldn.dibmp.vo.Member;
import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.vo.StorageApplyDetails;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/storageaudit/*")
public class StorageAuditActionBack extends AbstractAction {
	private static final String TITLE = "入库审核" ;
	@Resource
	private IStorageApplyService storageApplyService ; 
	@Resource
	private IStorageApplyDetailsService storageApplyDetailsService ; 
	@Resource
	private IStorageRecordService storageRecordService ; 
	@Resource
	private IMemberService memberService ; 
	
	@RequestMapping("list_prepare") 
	public ModelAndView listDetails() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title", "storage.audit.list.prepare.action") ;
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.list.prepare.page"));
		mav.addObject("allApplys", this.storageApplyService.listApp()) ; 
		mav.addObject("NumAndPrice", this.storageApplyDetailsService.getNumAndPrice()) ; 
		return mav;
	}
	@RequestMapping("edit_pre") 
	public ModelAndView editPre(long said) {
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.edit.page"));
		mav.addAllObjects(this.storageApplyService.findToMap(said)) ;
		mav.addObject("storageDetails", this.storageApplyDetailsService.getBySaid(said)) ; 
		//System.err.println(this.storageApplyService.findToMap(said));
		return mav;
	}
	@RequestMapping("edit")
	public ModelAndView edit(long said,int audit) {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title", "storage.audit.list.prepare.action") ;
		//ModelAndView mav = this.listDetails() ;
		String mid = (String)SecurityUtils.getSubject().getPrincipal() ;  
		System.err.println(this.storageApplyService.findBySaid(said));
		System.err.println(this.storageApplyDetailsService.getNumAndPriceBySaid(said));
		if(audit==1) { //审核通过
			StorageApply voa = this.storageApplyService.findBySaid(said) ; 
			StorageApplyDetails vob = this.storageApplyDetailsService.getNumAndPriceBySaid(said);
			this.storageRecordService.addToStorage(voa, vob,mid) ; 
			System.err.println(mid);
			this.storageApplyService.RemoveStorageApply(said); //审核不管通过不通过都逻辑删除
		}
		if(audit==2) { //审核不通过
			this.storageApplyService.RemoveStorageApply(said); //审核不管通过不通过都逻辑删除
		}
		System.err.println(audit);
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.list.prepare.page"));
		mav.addObject("allApplys", this.storageApplyService.listApp()) ; 
		mav.addObject("NumAndPrice", this.storageApplyDetailsService.getNumAndPrice()) ;
		return mav ; 
	}
	@RequestMapping("list_history") 
	public ModelAndView listMyself() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title", "storage.audit.list.history.action") ;
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.list.history.page"));
		mav.addObject("allStorageRecord", this.storageRecordService.getAllStorageRecord()) ; 
		System.err.println(this.storageRecordService.getAllStorageRecord());
		return mav;
	}
	@RequestMapping("member_info")
	public @ResponseBody Map<String,Object> memberInfo(String mid) {
		System.err.println(mid);
		Member vom = this.memberService.get(mid) ;
		List<Level> vol = this.memberService.getAllLevel() ; 
		List<Dept> vod = this.memberService.getAllDept() ; 
		System.err.println(vom);
		System.err.println(vol);
		System.err.println(vod);
		Map<String,Object> map = new HashMap<String,Object>() ; 
		map.put("member", vom) ; 
		map.put("level", vol) ; 
		map.put("dept", vod) ; 
		return map ; 
	}
	@RequestMapping("storage_info")
	public @ResponseBody Map<String,Object> storageInfo(Long said) {
		System.err.println(said);
		 Map<String,Object> map = new HashMap<String,Object>() ; 
		 StorageApply voa = this.storageApplyService.findBySaid(said) ; 
		 StorageApplyDetails vod = this.storageApplyDetailsService.getNumAndPriceBySaid(said) ;
		 List<StorageApplyDetails> vodd = this.storageApplyDetailsService.getBySaid(said); 
		 System.err.print(voa+" + "+vod);
		 map.put("sapply", voa) ; 
		 map.put("sadetails", vod) ; 
		 map.put("allsad", vodd) ; 
		return map; 
	}
}
