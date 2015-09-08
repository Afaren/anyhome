package entity;

import java.io.Serializable;

/**
 * @author : Chen
 * @fileName : entity.OrderStates.java
 * 
 * @date: Sep 8, 2015 10:10:32 AM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class OrderStates implements Serializable {
	// state����Ӧ����Ϊpublic��������ʹ������ֱ�ӷ���
	public static final int SEARCH_ALL_ORDER = 0;// ��ѯ���ж���
	public static final int CHECKING_ORDER = 1; // �������ɣ���ȷ�ϣ������
	public static final int ACCEPT_WAIT_PAY_ORDER = 2; // host���ܶ�����������
	public static final int CANCEL_ORDER = 3; // ����ȡ������
	public static final int REJECT_ORDER = 4; // �����ܾ�����
	public static final int WAIT_CHECKIN_ORDER = 5; // �����Ѹ������ס
	public static final int LIVING_ORDER = 6; // ��ס��
	public static final int ACCOMPLISH_ORDER = 7; // �����

}
