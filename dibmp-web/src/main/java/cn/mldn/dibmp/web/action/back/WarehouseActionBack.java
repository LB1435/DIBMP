package cn.mldn.dibmp.web.action.back;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.service.IWarehouseService;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/warehouse/*")
public class WarehouseActionBack extends AbstractAction {
	private static final String TITLE = "仓库" ;
	
	@Resource
	private IWarehouseService whService;
	
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.add.page"));
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "warehouse.add.action", "vo.add.success", TITLE);
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
		SplitPageUtil spu = new SplitPageUtil("仓库名称:name|仓库地址:address", "warehouse.list.action") ;
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.list.page"));
		mav.addAllObjects(whService.getAll());
//		System.out.println(whService.getAll());
		return mav;
	}
}
