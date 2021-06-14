package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import entity.User;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, String> {

    List<User> findAllByName(String username);//просто правильное название метода даст возможность
    //избежать запросов на SQL

    @Query(value = "select * from users where name limit 10", nativeQuery = true)
        //если и этого мало - можно написать запрос на чистом SQL и все это будет работать
    List<User> findWhereNameStartsFromSmith();


}