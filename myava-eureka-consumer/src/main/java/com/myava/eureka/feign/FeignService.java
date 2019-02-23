package com.myava.eureka.feign;

public interface FeignService {
    
    /**
     * @fun 通过url创建feign客户端实例
     * @param apiType feign接口类
     * @param url 动态url，包含协议、ip、端口、根目录
     * @return
     */
    public <T> T newInstanceByUrl(Class<T> apiType, String url);
    
    /**
     * @fun 通过服务名创建url 
     * @param apiType feign接口类
     * @param name 动态名称，包含协议、名称、根目录
     * @return
     */
    public <T> T newInstanceByName(Class<T> apiType, String name);

}
