package application.data.repository;

import application.data.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    @Query(value = "select MAX(id) from tbl_message",nativeQuery = true)
    int getLastMessgeId();

    @Query(value = "SELECT * FROM tbl_message WHERE id BETWEEN :minid AND :maxid", nativeQuery = true)
    ArrayList<Message> getListMessage(@Param("minid")int minid,
                                      @Param("maxid")int maxid);
}
