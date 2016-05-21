package pers.ethan.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class VIPSystem {
	/** 使用List组织，可通过下标获取会员 */
	private List<VIP> vipList;
	/** 使用Map组织，键为会员号，值为会员对象 */
	private Map<String, VIP> vipMap;
	/** 使用Set组织，无序 */
	private Set<VIP> vipSet;
	/** 使用SortedSet组织，有序 */
	private SortedSet<VIP> vipSortedSet;
	private static VIPSystem instance = new VIPSystem();
	
	public static VIPSystem getInstance(){
		return instance;
	}
	
	private VIPSystem(){
		vipList = new ArrayList<VIP>();
		vipMap = new HashMap<String, VIP>();
		vipSet = new HashSet<VIP>();
		vipSortedSet = new TreeSet<VIP>();
	}
	
	/**
	 * desc:注册
	 * <p>创建人：huangzhe , 2016年5月20日下午6:16:43</p>
	 * @param name
	 * @return
	 */
	public boolean register(String name){
		VIP vip = null;
		try {
			vip = new VIP(name);
			vipList.add(vip);
			vipMap.put(vip.vipNo, vip);
			vipSet.add(vip);
			vipSortedSet.add(vip);
		} catch (Exception e) {
			return false;
		}
		System.out.println("注册会员成功，会员信息：" + vip);
		return true;
	}
	
	/**
	 * desc:删除
	 * <p>创建人：huangzhe , 2016年5月20日下午6:16:49</p>
	 * @param vipNo
	 * @return
	 */
	public boolean remove(String vipNo){
		VIP vip = null;
		try {
			vip = vipMap.get(vipNo);
			vip.state = VIP.STATE_UNAVALIBLE;
			vipList.remove(vip);
			vipSet.remove(vip);
			vipSortedSet.remove(vip);
		} catch (Exception e) {
			return false;
		}
		System.out.println("删除成功，被删除的会员是：" + vip);
		return true;
	}
	
	public void showVIPs(){
		System.out.println("遍历vipList：");
		for (VIP vip : vipList) {
			System.out.println(vip);
		}
		System.out.println();
		
		System.out.println("遍历vipMap：");
		Iterator<String> mapIterator = vipMap.keySet().iterator();
		while (mapIterator.hasNext()) {
			String key = (String) mapIterator.next();
			System.out.println(vipMap.get(key));
		}
		System.out.println();
		
		System.out.println("遍历vipSet：");
		Iterator<VIP> setIterator = vipSet.iterator();
		while (setIterator.hasNext()) {
			VIPSystem.VIP vip = (VIPSystem.VIP) setIterator.next();
			System.out.println(vip);
		}
		System.out.println();
		
		System.out.println("遍历vipSortedSet：");
		Iterator<VIP> sortedSetiterator = vipSortedSet.iterator();
		while (sortedSetiterator.hasNext()) {
			VIPSystem.VIP vip = (VIPSystem.VIP) sortedSetiterator.next();
			System.out.println(vip);
		}
		System.out.println();
	}
	
	/**
	 * desc:按照下标检索
	 * <p>创建人：huangzhe , 2016年5月21日上午9:03:04</p>
	 * @param index
	 * @return
	 */
	public VIP getVIPByIndex(int index){
		if (index < 0 || index >= vipList.size()) {
			System.out.println("下标越界，检索失败...");
		}
		return vipList.get(index);
	}

	/**
	 * desc:按照会员号检索
	 * <p>创建人：huangzhe , 2016年5月21日上午9:07:09</p>
	 * @param vipNo
	 * @return
	 */
	public VIP getVIPByVIPNo(String vipNo){
		return vipMap.get(vipNo);
	}
	
	public static void main(String[] args) {
		VIPSystem vipSystem = VIPSystem.getInstance();
		String[] toBeVip = {"King", "Echo", "Earl", "Ethan", "Danny"};
		for (int i = 0; i < toBeVip.length; i++) {
			vipSystem.register(toBeVip[i]);
		}
		// 遍历
		vipSystem.showVIPs();
		
		// 按照下标检索
		int index = 3;
		VIP vipByIndex = vipSystem.getVIPByIndex(index);
		System.out.println("按照下标检索，下标：" + index + "，会员信息：" + vipByIndex);
		
		// 按照会员号检索
		String  vipNo = "00000003";
		VIP vipByVIPNo = vipSystem.getVIPByVIPNo(vipNo);
		System.out.println("按照会员号检索，会员号：" + vipNo + "，会员信息：" + vipByVIPNo);
		
		vipSystem.remove("00000003");
		System.out.println("删除00000003 --------------------------------------");
		// 遍历
		vipSystem.showVIPs();
		
		// 按照下标检索
		vipByIndex = vipSystem.getVIPByIndex(index);
		System.out.println("按照下标检索，下标：" + index + "，会员信息：" + vipByIndex);
		
		// 按照会员号检索
		vipByVIPNo = vipSystem.getVIPByVIPNo(vipNo);
		System.out.println("按照会员号检索，会员号：" + vipNo + "，会员信息：" + vipByVIPNo);
	}
	
	
	private static class VIP{
		/** 会员号 */
		private String vipNo;
		/** 会员名称 */
		private String name;
		/** 状态 */
		private short state;
		/** 存储最大会员号 */
		static int maxVIPNo;
		private static final short STATE_AVAILABLE = 1;
		private static final short STATE_UNAVALIBLE = 0;
		
		
		public VIP(String name) {
			this.vipNo = String.format("%08d", maxVIPNo++);
			this.name = name;
			this.state = STATE_AVAILABLE;
		}


		@Override
		public String toString() {
			return "VIP [vipNo=" + vipNo + ", name=" + name + ", state="
					+ state + "]";
		}
		
		
	}
}


