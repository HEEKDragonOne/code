import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.tothefor.entity.User;
import com.tothefor.utils.MongoDBUtils;
import com.tothefor.utils.MySQLUtils;
import com.tothefor.utils.RedisUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author DragonOne
 * @Date 2021/11/16 14:20
 */
public class JunitTEST {

    @Test
    public void testPr(){
        MongoDatabase db = MongoDBUtils.getMongoDatabase("NoSQL");
        System.out.println(db.getName());
        MongoCollection mc = MongoDBUtils.getCollection("NoSQL","homew");
        System.out.println(mc.getNamespace());

        FindIterable findIterable = mc.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
//        while(cursor.hasNext()){
//            Document docu = cursor.next();
//        }
        System.out.println("OK");
    }


    @Test
    public void testjson() throws JsonProcessingException {
        User userk = new User();
        userk.setAddress("qwer");
        userk.setAge(23);
        userk.setPTID("234");
        userk.setTele("23423");
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(userk);
        System.out.println(json);
    }
    //测试MySQL数据库
    @Test
    public void testmysql() throws Exception{
        Connection connection = MySQLUtils.getConnection();
        String sql ="select * from Users";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            System.out.println(s1+" | "+s2+" | ");
        }
        MySQLUtils.closeAll(connection,ps,rs);
    }

    @SuppressWarnings("all")
    @Test
    public void testRedis(){
//        String code = RedisUtils.MCode("12245"); //先通过手机号生成验证码
//        System.out.println(code);
        boolean flag = RedisUtils.getRcode("12245","979821");  //检验验证码是否正确
        if(flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
    @Test
    public void tesetcr(){
        MongoDatabase db = MongoDBUtils.getMongoDatabase("NoSQL");
        System.out.println(db.getName());
        MongoCollection mc = MongoDBUtils.getCollection("NoSQL","beijing");
        mc.drop();
        db.createCollection("beijing");
    }

    @Test
    public void testlf(){
        String s = "16556.0";
        float f = 16556.0f;
        System.out.println((long) f);
    }

}
