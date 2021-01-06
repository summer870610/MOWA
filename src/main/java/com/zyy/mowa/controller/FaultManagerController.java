package com.zyy.mowa.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyy.mowa.dao.AttachmentImage;
import com.zyy.mowa.dao.Fault;
import com.zyy.mowa.dao.MaintenanceRecord;
import com.zyy.mowa.dto.FaultDetailDto;
import com.zyy.mowa.dto.FaultDto;
import com.zyy.mowa.dto.FaultListDto;
import com.zyy.mowa.dto.FaultPageDto;
import com.zyy.mowa.dto.Result;
import com.zyy.mowa.dto.WorkGroupOutputDto;
import com.zyy.mowa.service.FaultManagerService;
import com.zyy.mowa.utils.SenInfoCheckUtil;
import com.zyy.mowa.utils.JwtUtils.UserLoginToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@Api(tags = "维修管理")
@RestController
@RequestMapping("api/FaultManager")
public class FaultManagerController {
	@Autowired
	private FaultManagerService faultManagerService;
	@UserLoginToken
	@ApiOperation(value = "创建故障信息")
	@PostMapping("/creatFault")
	public Result<Integer> creatFault(@RequestBody FaultDto record) {
		
		return new Result<Integer>(faultManagerService.creatFault(record));
	}
	@UserLoginToken
	@ApiOperation(value = "修改故障信息")
	@PostMapping("/updateFault")
	public Result<Integer> updateFault(@RequestBody Fault record) {
		return new Result<Integer>( faultManagerService.updateFault(record));
	}
	@UserLoginToken
	@ApiOperation(value = "创建维修记录")
	@PostMapping("/creatRecord")
	public Result<Integer> creatRecord(@RequestBody MaintenanceRecord record) {
		return new Result<Integer>( faultManagerService.creatRecord(record));
	}
	@UserLoginToken
	@ApiOperation(value = "更新指定一条维修记录")
	@PostMapping("/updateRecord")
	public Result<Integer> updateRecord(@RequestBody MaintenanceRecord record) {
		return new Result<Integer>( faultManagerService.updateRecord(record));
	}
	@UserLoginToken
	@ApiOperation(value = "删除故障信息")
	@PostMapping("/deleteFault")
	public Result<Integer> deleteFault(@RequestBody int id) {
		return new Result<Integer>( faultManagerService.deleteFault(id));
	}
	@UserLoginToken
	@ApiOperation(value = "删除维修记录")
	@PostMapping("/deleteRecord")
	public Result<Integer> deleteRecord(@RequestBody int id) {
		return new Result<Integer> (faultManagerService.deleteRecord(id));
	}
	
	@UserLoginToken
	@ApiOperation(value = "查询维修列表")
	@PostMapping("/selectFaults")
	public Result<PageInfo<FaultListDto>> selectFaults(@RequestBody FaultPageDto input) {
		 PageHelper.startPage(input.getPageNum(), input.getPageSize());
		DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月");
		DateFormat dateFormat24 = new SimpleDateFormat("yyyy-MM-dd");
		List<FaultListDto> result=new ArrayList<FaultListDto>();
		List<Fault> dataFaults=faultManagerService.selectFaults(input.getFault());
				Map<String, List<Fault>>  data=dataFaults.stream().collect(Collectors.groupingBy(b ->
				{
					try {
						return dateFormat.format(dateFormat24.parse(b.getCreatetime()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "0000";
				}		
				));
				data.forEach((k,v)->{
					FaultListDto dto=new FaultListDto();
					dto.setMonth(k);
					dto.setList(v);
 					result.add(dto);
				});
				  PageInfo<FaultListDto> pageInfo = new PageInfo<FaultListDto>(result);
		return new Result<PageInfo<FaultListDto>>(pageInfo);
	}
	@UserLoginToken
	@ApiOperation(value = "查询故障明细")
	@PostMapping("/getFaultDetail")
	public Result<FaultDetailDto> getFaultDetail(@RequestBody Integer id) {
		FaultDetailDto data=faultManagerService.getFaultDetail(id);
		return new Result<FaultDetailDto>(data);
	}
	@UserLoginToken
	@ApiOperation(value = "查询某个故障下维修记录")
	@PostMapping("/getMaintenanceRecords")
	public Result<List<MaintenanceRecord>> getMaintenanceRecords(@RequestBody MaintenanceRecord record) {
		return new Result<List<MaintenanceRecord>>( faultManagerService.getMaintenanceRecords(record));
	}
	@UserLoginToken
	@ApiOperation(value = "多个图片审核上传")
	@PostMapping("/ManyUpload")
    public Result<List<Integer>> manyUpload(HttpServletRequest request,AttachmentImage image) throws IOException {
      String uploadFolder =
            ClassUtils.getDefaultClassLoader().getResource("static/image").getPath().substring(1) + "/";
        
        String serviceRoot = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/image/";
        CommonsMultipartResolver commonsMultipartResolver =
            new CommonsMultipartResolver(request.getSession().getServletContext());
        commonsMultipartResolver.setDefaultEncoding("utf-8");
      String token= SenInfoCheckUtil.getWxToken();
      //List<String> pathList=new ArrayList<String>();
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest mulReq = (MultipartHttpServletRequest)request;
          
            Map<String, MultipartFile> map = mulReq.getFileMap();
            //StringBuilder paths = new StringBuilder();
           List<Integer> ids=new ArrayList<Integer>();
            // key为前端的name属性，value为上传的对象（MultipartFile）
            for (Map.Entry<String, MultipartFile> entry : map.entrySet()) {
                MultipartFile file = entry.getValue();
              boolean isOk=  SenInfoCheckUtil.toCheckImg(file,token);
              if(isOk) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get( URLDecoder.decode(uploadFolder, "UTF-8") + file.getOriginalFilename());
                Files.write(path, bytes);
                image.setImageurl(serviceRoot+file.getOriginalFilename());
                image.setImagesize(file.getSize()+"");
                image.setCreatetime(new Date());
             int id= faultManagerService.createAttachmentImage(image);
            ids.add(id);
				//if ("".equals(paths)) {
               //     paths.append(serviceRoot).append(file.getOriginalFilename());
               // } else {
               //     paths.append(";").append(serviceRoot).append(file.getOriginalFilename());
               // }
             }else {
            	  return new  Result<List<Integer>>(87014,"存在不合规的图片");
              }
            }
            return new Result<List<Integer>>(ids);//pathList.add(paths.toString());
           // input.setFilePathList(pathList);
        }else {
        	return new Result<List<Integer>>(404,"空文件");
		}
        
        
       
    }
	@UserLoginToken
	@ApiOperation(value = "单个图片审核上传")
	@PostMapping("/upload")
    public Result<AttachmentImage> upload(HttpServletRequest request,AttachmentImage image) throws IOException {
      String uploadFolder =
            ClassUtils.getDefaultClassLoader().getResource("static/image").getPath().substring(1) + "/";
        
        String serviceRoot = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/image/";
        CommonsMultipartResolver commonsMultipartResolver =
            new CommonsMultipartResolver(request.getSession().getServletContext());
        commonsMultipartResolver.setDefaultEncoding("utf-8");
      String token= SenInfoCheckUtil.getWxToken();
      //List<String> pathList=new ArrayList<String>();
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest mulReq = (MultipartHttpServletRequest)request;
            Map<String, MultipartFile> map = mulReq.getFileMap();
            for (Map.Entry<String, MultipartFile> entry : map.entrySet()) {
                MultipartFile file = entry.getValue();
            
           
            // key为前端的name属性，value为上传的对象（MultipartFile）
               
              boolean isOk=  SenInfoCheckUtil.toCheckImg(file,token);
              if(isOk) {
            	  
                byte[] bytes = file.getBytes();
                Path path = Paths.get( URLDecoder.decode(uploadFolder, "UTF-8") + file.getOriginalFilename());
                Files.write(path, bytes);
                image.setImageurl(serviceRoot+file.getOriginalFilename());
                image.setImagesize(file.getSize()+"");
                image.setCreatetime(new Date());
             int id= faultManagerService.createAttachmentImage(image);
           image.setId(id);
         
             
             }else {
            	  return new  Result<AttachmentImage>(87014,"存在不合规的图片");
              }
            }
            return new Result<AttachmentImage>(image);
            }else {
            	return new Result<AttachmentImage>(404,"空文件");
    		}
         
        
        
        
       
    }
	
	
	
}
