package designpattern.builder;

import java.util.Collection;
import java.util.Map;

public interface Builder {

	 /**
     * ��������ļ���Header����
     * @param ehm �ļ�ͷ������
     */
	public void buildHeader(ExportHeaderModel ehm);
	
	/**
	* ��������ļ���Body����
	* @param mapData Ҫ��������ݵ�����
	*/
	public void buildBody(Map<String, Collection<ExportDataModel>> mapData);
	
	/**
     * ��������ļ���Footer����
     * @param efm �ļ�β������
     */
	public void buildFooter(ExportFooterModel efm);
}
