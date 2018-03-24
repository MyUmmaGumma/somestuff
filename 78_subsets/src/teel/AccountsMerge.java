package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AccountsMerge {
	//Map name to some ID
	Map<String, Integer> m = null;
	Map<Integer, Set<String>> ms = null;
	Map<String, Integer> ei = null;
	
	class UF
	{
		Integer []arr = null;
		public UF(int n) {
			arr = new Integer [n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
		}
		
		int FindRoot(int element)
		{
			if (arr[element] == element) {
				return arr[element];
			} else {
				while (arr[element] != element) {
					element = arr[element];
				}
			}
			return arr[element];
		}
		
		void Union(int a1, int a2)
		{
			if (a1 == a2) return;
			
			int r1 = FindRoot(a1);
			int r2 = FindRoot(a2);
			arr[r1] = r2;
		}
	}
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		AccountsMerge.UF uf = new UF(accounts.size());
		m = new HashMap<>();
		ms = new HashMap<>();
		ei = new HashMap<>();
		
		for (int i = 0; i < accounts.size(); i++) {
			List<String> nameemails = accounts.get(i);
			String name = nameemails.get(0);
			m.put(name, i);
			Set<String> s = new HashSet<>();
			s.addAll(nameemails);
			s.remove(name);
			ms.put(i, s);
			for (int j = 1; j < nameemails.size(); j++) {
				ei.put(nameemails.get(j), i);
			}
		}
		
		for (int i = 0; i < accounts.size(); i++) {
			List<String> nameemails = accounts.get(i);
			int leader = m.get(nameemails.get(0));
			for (int j = 1; j < nameemails.size(); j++) {
				int val = ei.get(nameemails.get(j));
				if (val != leader) {
					uf.Union(leader, val);
					if (ms.containsKey(val)) {
						if (ms.get(val) != null) {
							ms.get(leader).addAll(ms.get(val));
							ms.put(val, null);
						}
					}
				}
			}
		}
		List<List<String>> lsfilled= new ArrayList<>();
		for (Entry<String, Integer> e : m.entrySet()) {
			if (ms.get(e.getValue()) == null) continue;
			Set<String> s = ms.get(e.getValue());
		}
		return accounts;
    }
}
