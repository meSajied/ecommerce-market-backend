package org.ecommerce.vendor;

import org.ecommerce.products.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vendors")
@CrossOrigin(origins = "http://localhost:3000")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        List<Vendor> vendors = vendorService.getListOfVendors();
        return ResponseEntity.ok(vendors);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getProductsByVendor(@PathVariable Long id) {
        List<Product> products = vendorService.productsOfVendorOfId(id);
        return products != null ? ResponseEntity.ok(products) : ResponseEntity.notFound().build();
    }
}
