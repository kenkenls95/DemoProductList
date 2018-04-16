package application.controller.web;

import application.viewmodel.common.LayoutHeaderVM;
import application.viewmodel.common.LogoVM;
import application.viewmodel.homelanding.MenuItemVM;

import java.util.ArrayList;

/**
 * Created by ManhNguyen on 1/30/18.
 */
public abstract class BaseController {

    public void setLayoutHeaderVM(LayoutHeaderVM vm) {
        LogoVM logo = new LogoVM("SpringMVC",
                "/img/logo.png", "SpringMVC", "SMVC");

        ArrayList<MenuItemVM> listHrMenuItems = new ArrayList<>();
        listHrMenuItems.add(new MenuItemVM("Menu 01", "/"));
        listHrMenuItems.add(new MenuItemVM("Menu 02", "/"));
        listHrMenuItems.add(new MenuItemVM("Menu 03", "/"));
        listHrMenuItems.add(new MenuItemVM("Menu 04", "/"));

        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("Menu 01 - 01", "/"));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("Menu 01 - 02", "/"));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("Menu 01 - 03", "/"));
        listHrMenuItems.get(0).getChildren().add(new MenuItemVM("Menu 01 - 04", "/"));

        vm.setLogo(logo);
        vm.setListHrMenuItems(listHrMenuItems);
    }

}
