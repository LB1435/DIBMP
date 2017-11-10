package cn.mldn.dibmp.web.action.back;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.service.IWarehouseService;
import cn.mldn.dibmp.vo.City;
import cn.mldn.dibmp.vo.Warehouse;
import cn.mldn.util.fastDFSUtil;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/warehouse/*")
public class WarehouseActionBack extends AbstractAction {
	private static final String TITLE = "仓库" ;
	
	@Resource
	private IWarehouseService whService;
	
	@RequestMapping("addCity")
	@ResponseBody
	public Object addCity(Long pid) {
//		Long mypid = Long.parseLong(pid);
		List<City> mycity = whService.getCityByPid(pid);
		return mycity;
	}
	
	@RequestMapping("getDept")
	@ResponseBody
	public Object getDept() {
		return whService.getAllDept();
	}
	
	@RequestMapping("editAdmin")
	@ResponseBody
	public boolean editAdmin(long wid,String admin) {
		whService.EditByWid(wid, admin) ; 
		System.out.println(whService.EditByWid(wid, admin));
		return whService.EditByWid(wid, admin);
	}
	
	@RequestMapping("getMember")
	@ResponseBody
	public Object getMember(Long did,Long wid) {
		System.err.println("************");
		System.err.println("did="+did+"、wid="+wid);
		System.err.println(whService.getMemberByDid(did));
		return whService.getMemberByDid(did);
	}
	
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.add.page"));
		mav.addAllObjects(whService.getAllProvice());
		mav.addAllObjects(whService.getAllWitem());
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add(Warehouse wh,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		String photo = fastDFSUtil.upload(pic);
		wh.setPhoto(photo);
		wh.setCurrnum(0);
		if (whService.add(wh)) {
			super.setMsgAndUrl(mav, "warehouse.add.action", "vo.add.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "warehouse.add.action", "vo.add.failure", TITLE);
		}
		return mav;
	}
	@RequestMapping("edit_pre")
	public ModelAndView editPre(long wid) {
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.edit.page"));
		return mav;
	}
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "warehouse.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequestMapping("list")
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("仓库名称:name|仓库地址:address", super.getPage("warehouse.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.list.page"));
		mav.addAllObjects(whService.list(spu.getCurrentPage(), spu.getLineSize(),null, null));
////		System.err.println(whService.getAll());
//		System.err.println(spu.getCurrentPage());
//		System.err.println(spu.getLineSize());
//		System.err.println(spu.getColumn());
//		System.err.println(spu.getKeyWord());
		return mav;
	}
}
