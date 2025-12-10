package knapsack;

import java.util.ArrayList;
import java.util.HashMap;

public class KnapSackService {
	private int weight;
	private int maximumValue;
	private ArrayList<Integer> listeArticle;
	
	private ArrayList<Integer> listElement;
	public KnapSackService(int weight, int maximumValue) {
		this.weight = weight;
		this.listeArticle = new ArrayList<>();
		this.listElement = new ArrayList<>();
		this.maximumValue = maximumValue;
	}
	
	public int getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(int maximumValue) {
		this.maximumValue = maximumValue;
	}

	public ArrayList<Integer> getListeArticle() {
		return listeArticle;
	}

	public void setListeArticle(ArrayList<Integer> listeArticle) {
		this.listeArticle = listeArticle;
	}
	
	public ArrayList<Integer> getListElement() {
		return listElement;
	}

	public void setListElement(ArrayList<Integer> listElement) {
		this.listElement = listElement;
	}

	public void KnapSackMethod(int i, int totalWeight, int totalValue, int[] value, int[] weight) {
		int n = value.length;
		
		if(totalWeight + weight[i] <= this.weight) {
			listElement.add(i);
			
			if(i < n - 1) {
				KnapSackMethod(i + 1, totalWeight + weight[i], totalValue, value, weight);
			}
			else if(totalValue > this.maximumValue){
				this.maximumValue = totalValue ;
				this.listeArticle = new ArrayList<>(listElement);
			}
			
			listElement.remove(Integer.valueOf(i));
		}
		
		int totalValue1 = totalValue - value[i];
		
		if(totalValue1 > this.maximumValue) {
			if(i < n - 1) {
				KnapSackMethod(i + 1, totalWeight, totalValue1, value, weight);
			}
			else {
				this.maximumValue = totalValue1;
				this.listeArticle = new ArrayList<>(listElement);
			}
		}
		
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		String val = "";
		for(int i =0; i < listeArticle.size(); i++) {
			if(i != listeArticle.size() - 1) {
				val += listeArticle.get(i) + " - ";
			}
			else {
				val += listeArticle.get(i);
			}
		}
		return val;
	}
	
	
}
