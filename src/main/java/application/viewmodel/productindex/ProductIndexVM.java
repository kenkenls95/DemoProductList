package application.viewmodel.productindex;

import application.model.ProductDetailModel;
import application.viewmodel.common.LayoutHeaderVM;

/**
 * Created by ManhNguyen on 1/30/18.
 */
public class ProductIndexVM extends LayoutHeaderVM {

    private ProductDetailModel info;

    public ProductDetailModel getInfo() {
        return info;
    }

    public void setInfo(ProductDetailModel info) {
        this.info = info;
    }
}
