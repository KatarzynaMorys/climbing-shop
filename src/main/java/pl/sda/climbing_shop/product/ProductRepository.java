package pl.sda.climbing_shop.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sda.climbing_shop.brand.Brand;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findProductsByCategory_CategoryName(String categoryName);

    List<Product> findProductsByCategory_CategoryNameAndProductType(String categoryName, String productType);

    @Query("select distinct p.productColor from Product p where p.category.categoryName = ?1")
    List<String> findDistinctColors(String category);

    @Query("select distinct p.productSize from Product p where p.category.categoryName = ?1 order by p.productSize")
    List<String> findDistinctSizes(String category);

    @Query("select distinct p.productType from Product p where p.category.categoryName = ?1")
    List<String> findDistinctTypes(String category);

    @Query("select distinct p.brand from Product p where p.category.categoryName = ?1")
    List<Brand> findDistinctBrands(String category);

    @Query("select distinct p.productColor from Product p where p.category.categoryName = ?1 and p.productType = ?2")
    List<String> findDistinctClothingColors(String category, String type);

    @Query("select distinct p.productSize from Product p where p.category.categoryName = ?1 and p.productType = ?2")
    List<String> findDistinctClothingSizes(String category, String type);

    @Query("select distinct p.productSubtype from Product p where p.category.categoryName = ?1 and p.productType = ?2")
    List<String> findDistinctClothingSubtypes(String category, String type);

    @Query("select distinct p.brand from Product p where p.category.categoryName = ?1 and p.productType = ?2")
    List<Brand> findDistinctClothingBrands(String category, String type);

}