package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Folder;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    //query = select * from folder where user_id = ? and name in (?, ? ,?);
    List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);

    List<Folder> findAllByUser(User user);

}
