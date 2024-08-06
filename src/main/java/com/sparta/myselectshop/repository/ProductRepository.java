package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUser(User user, PageRequest pageable);

    // query =>
    // select * from product p left join product_folder pf on p.id = pf.product_id
    // where p.user_id = ? and pf.folder_id = ?
    // order by p.id
    // limit 10, 10;
    Page<Product> findAllByUserAndProductFolders_FolderId(User user, Long folderId, PageRequest pageable);

}
