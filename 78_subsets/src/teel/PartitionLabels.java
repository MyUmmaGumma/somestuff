package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		Map<Character, Integer> m = new HashMap<>();
		char []arr = S.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			m.put(arr[i], i);
		}
		StringBuilder sb = new StringBuilder();
		List<Integer> li = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (m.get(arr[i]) != i) {
				sb.append(arr[i]);
			} else {
				sb.append(arr[i]);
				boolean all_past = true;
				for (int j = 0; j < sb.length(); j++) {
					if (m.get(sb.charAt(j)) > i) {
						all_past = false;
						break;
					}
				}
				if (all_past) {
					li.add(sb.length());
					sb = new StringBuilder();
				}
			}
		}
		return li;
    }
}
