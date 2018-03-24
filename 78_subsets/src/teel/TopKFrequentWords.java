package teel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		class HeapNode {
			String word;
			int count;
			public HeapNode(String w) {
				word = w; count = 1;
			}
			@Override
			public boolean equals(Object o)
			{
				if (o == this) {
					return true;
				}
				HeapNode n = (HeapNode)o;
				if (word.contentEquals(n.word)) {
					return true;
				}
				return false;
			}
		}
		
		Comparator<HeapNode> hncomp = new Comparator<HeapNode>() {

			@Override
			public int compare(HeapNode arg0, HeapNode arg1) {
				if (arg1.count == arg0.count) {
					//return Integer.compare(arg0.word.length(), arg1.word.length());
					//Use lexicographic compare instead of comparing lengths
					return arg0.word.compareTo(arg1.word); 
				}
				return Integer.compare(arg1.count, arg0.count);
			}
		};
		
		PriorityQueue<HeapNode> pq = new PriorityQueue<>(words.length, hncomp);
		HashMap<String, HeapNode> hm = new HashMap<>();
		List<String> ret = new ArrayList<>();
		for (String word : words) {
			HeapNode hn = null;
			if (hm.containsKey(word)) {
				//Should not create heap node first and then compare because updates to the
				// removed heap node from the PQ is to the local heap node object and not the
				// one that got removed from PQ
				hn = hm.get(word);
				pq.remove(hn);
				hn.count = hn.count+1;
			}  else {
				hn = new HeapNode(word);
				hm.put(word, hn);
			}
			pq.add(hn);
		}
		for (int i = 0; i < k; i++) {
			ret.add(pq.poll().word);
		}
		return ret;
    }
}
