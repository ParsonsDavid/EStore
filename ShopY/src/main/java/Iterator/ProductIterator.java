package Iterator;

import entity.Product;

import java.util.List;

/**
 * Created by David on 17/04/2017.
 */
public class ProductIterator implements Iterator{

            List<Product> products;

         int position = 0;

            public ProductIterator(List<Product> products){
                this.products = products;
            }

             public boolean hasNext() {
                 return position < products.size();
            }

             public Product next() {
                Product product = products.get(position);
                position++;
                return product;
            }
 }