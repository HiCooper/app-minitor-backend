package com.berry.appmonitor.common;

import com.berry.appmonitor.common.constant.XmlErrorInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-06-23 00:16
 * fileName：XmlResponse
 * Use：Get请求 错误响应，多用于读取文件
 */
@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "ERROR")
public class XmlResponse {

    @JacksonXmlProperty(localName = "INFO")
    public XmlErrorInfo xmlErrorInfo;

    public XmlResponse(XmlErrorInfo xmlErrorInfo) {
        this.xmlErrorInfo = xmlErrorInfo;
    }
}
