package com.zyy.mowa.mapper;

import com.zyy.mowa.dao.AttachmentImage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AttachmentImageMapper {
    @Delete({
        "delete from ma_attachmentimage",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ma_attachmentimage (Id, ImageUrl, ",
        "ImageSize, PictureFormat, ",
        "FaultId)",
        "values (#{id,jdbcType=INTEGER}, #{imageurl,jdbcType=VARCHAR}, ",
        "#{imagesize,jdbcType=VARCHAR}, #{pictureformat,jdbcType=VARCHAR}, ",
        "#{faultid,jdbcType=INTEGER})"
    })
    int insert(AttachmentImage record);

    @InsertProvider(type=AttachmentImageSqlProvider.class, method="insertSelective")
    int insertSelective(AttachmentImage record);

    @Select({
        "select",
        "Id, ImageUrl, ImageSize, PictureFormat, FaultId",
        "from ma_attachmentimage",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ImageUrl", property="imageurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="ImageSize", property="imagesize", jdbcType=JdbcType.VARCHAR),
        @Result(column="PictureFormat", property="pictureformat", jdbcType=JdbcType.VARCHAR),
        @Result(column="FaultId", property="faultid", jdbcType=JdbcType.INTEGER)
    })
    AttachmentImage selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AttachmentImageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AttachmentImage record);

    @Update({
        "update ma_attachmentimage",
        "set ImageUrl = #{imageurl,jdbcType=VARCHAR},",
          "ImageSize = #{imagesize,jdbcType=VARCHAR},",
          "PictureFormat = #{pictureformat,jdbcType=VARCHAR},",
          "FaultId = #{faultid,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AttachmentImage record);
}