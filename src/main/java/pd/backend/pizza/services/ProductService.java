package pd.backend.pizza.services;

import pd.backend.pizza.dto.ProductDTO;
import pd.backend.pizza.entities.Product;
import pd.backend.pizza.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){

        List<Product> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
        //return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }

    private String name;
    private Double price;
    private String description;
    private String imageUri;

    /*
    @Transactional
    public ProductDTO insert(Product dto){

        Product product = new Product(null, dto.getName(),dto.getPrice(), dto.getDescription(),
                dto.getImageURL());

        return product;
    }*/

}
