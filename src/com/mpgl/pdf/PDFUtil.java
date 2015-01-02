package com.mpgl.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * PDF文件操作工具类
 * 
 * @author 廖陈特
 * 
 */
public class PDFUtil {

	/**
	 * 
	 */
	private BaseFont baseFont = null;

	/**
	 * 
	 */
	private Font cnFont = null;

	/**
	 * 输出流
	 */
	private ByteArrayOutputStream baos = null;

	/**
	 * 输入流
	 */
	private ByteArrayInputStream bais = null;

	/**
	 * 构造函数
	 * 
	 * @throws Exception
	 */
	public PDFUtil() throws Exception {
		baseFont = BaseFont.createFont("C:/windows/fonts/simsun.ttc,1",
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		cnFont = new Font(baseFont, 5, Font.NORMAL, BaseColor.BLUE);
		baos = new ByteArrayOutputStream();
	}

	/**
	 * 导出-返回包含PDF文件的输入流
	 * 
	 * @param columns
	 * @param keys
	 * @param widths
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public ByteArrayInputStream exportStream(String[] columns, String[] keys,
			int[] widths, List<Map<String, Object>> list) throws Exception {
		createHouseNumberFile(columns, keys, widths, list);
		byte[] datas = baos.toByteArray();
		bais = new ByteArrayInputStream(datas, 0, datas.length);
		return bais;
	}

	/**
	 * 创建PDF文件
	 * 
	 * @param columns
	 * @param keys
	 * @param widths
	 * @param list
	 * @return
	 * @throws DocumentException
	 */
	public PdfWriter createHouseNumberFile(String[] columns, String[] keys,
			int[] widths, List<Map<String, Object>> list)
			throws DocumentException {
		Document document = new Document(PageSize.A4, 0, 0, 50, 0);
		PdfWriter pw = PdfWriter.getInstance(document, baos);
		document.open();
		PdfPTable table = new PdfPTable(columns.length);
		table.setWidths(widths);
		for (int i = 0; i < columns.length; i++) {
			PdfPCell cell = new PdfPCell(new Phrase(columns[i], cnFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				for (int j = 0; j < keys.length; j++) {
					PdfPCell cell = new PdfPCell(new Phrase(
							getValueByString(map.get(keys[j])), cnFont));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
				}
			}
		}
		document.add(table);
		document.close();
		return pw;
	}

	/**
	 * 数据转换
	 * 
	 * @param object
	 * @return
	 */
	public String getValueByString(Object object) {
		return object != null ? object.toString() : "";
	}
}
