package team.fjut.cf.mapper;

import team.fjut.cf.pojo.po.UserCheckIn;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户签到 mapper
 * @author axiang [2019/10/23]
 */
public interface UserCheckInMapper extends Mapper<UserCheckIn> {

    /**
     * 根据用户名查询全部用户签到记录
     *
     * @param username
     * @return
     */
    List<UserCheckIn> selectCheckInByUsername(@Param("username") String username);


    /**
     * 根据用户名查询用户今天的签到次数
     *
     * @param username
     * @return
     */
    Integer selectCountTodayCheckInByUsername(@Param("username") String username);

    /**
     * 根据用户查询签到记录
     *
     * @param username
     * @return
     */
    List<UserCheckIn> selectByUsername(@Param("username") String username);

}
