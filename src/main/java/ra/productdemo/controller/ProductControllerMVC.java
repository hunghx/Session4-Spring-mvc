package ra.productdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.productdemo.dto.ProductRequest;
import ra.productdemo.model.Product;
import ra.productdemo.service.IProductService;

import java.util.List;

@Controller // chú thích đây là thành phần controller
@RequestMapping("/product-controller")
public class ProductControllerMVC {
    @Autowired
    private IProductService productService;
    // liệt kê các phương thức cần  lí và đường dan của nó

    @RequestMapping(method = RequestMethod.GET)
    public String showAll(Model model){ // mapping với đường dẫn /product-controller - GET
        // lấy r danh sách
        List<Product> list = productService.findAll();
        model.addAttribute("list",list);
        return "product";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST) // map với đường dẫn /product-controller/add - POST
    public String add(@ModelAttribute ProductRequest productRequest){
        // lấy ra thông tin từ ô input
        productService.add(productRequest);
        return "redirect:/product-controller";
    }
}
