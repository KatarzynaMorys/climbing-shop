package pl.sda.climbing_shop.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findProductsByCategory_CategoryName(String categoryName);

    List<Product> findProductsByCategory_CategoryNameAndProductType(String categoryName, String productType);

    List<Product> findProductsByCategory_CategoryNameAndBrand_BrandNameAndProductTypeAndProductSizeAndProductColor
            (String category, String brand, String type, String size, String color);

    List<Product> findProductsByCategory_CategoryNameAndBrand_BrandNameAndProductSubtypeAndProductSizeAndProductColor
            (String category, String brand, String subtype, String size, String color);

    @Query("select distinct p.productColor from Product p where p.category.categoryName = ?1")
    List<String> findDistinctColors(String category);

    @Query("select distinct p.productSize from Product p where p.category.categoryName = ?1")
    List<String> findDistinctSizes(String category);

    @Query("select distinct p.productType from Product p where p.category.categoryName = ?1")
    List<String> findDistinctTypes(String category);

    @Query("select distinct p.brand.brandName from Product p where p.category.categoryName = ?1")
    List<String> findDistinctBrands(String category);

    @Query("select distinct p.productColor from Product p where p.category.categoryName = ?1 and p.productType = ?2")
    List<String> findDistinctClothingColors(String category, String type);

    @Query("select distinct p.productSize from Product p where p.category.categoryName = ?1 and p.productType = ?2")
    List<String> findDistinctClothingSizes(String category, String type);

    @Query("select distinct p.productSubtype from Product p where p.category.categoryName = ?1 and p.productType = ?2")
    List<String> findDistinctClothingSubtypes(String category, String type);

    @Query("select distinct p.brand.brandName from Product p where p.category.categoryName = ?1 and p.productType = ?2")
    List<String> findDistinctClothingBrands(String category, String type);
}
