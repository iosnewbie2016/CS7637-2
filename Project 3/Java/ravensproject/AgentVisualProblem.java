package ravensproject;

import ravensproject.AgentVisualFigure.combinationMethod;

public class AgentVisualProblem {

	AgentVisualFigure figA;    	
	AgentVisualFigure figB;    	
	AgentVisualFigure figC;    	
	AgentVisualFigure figD;    	
	AgentVisualFigure figE;    	
	AgentVisualFigure figF;    	
	AgentVisualFigure figG;    	
	AgentVisualFigure figH;    	
	AgentVisualFigure fig1;    	
	AgentVisualFigure fig2;    	
	AgentVisualFigure fig3;    	
	AgentVisualFigure fig4;    	
	AgentVisualFigure fig5;    	
	AgentVisualFigure fig6;   	
	AgentVisualFigure fig7;  	
	AgentVisualFigure fig8;
	
	float percentageToDeemEquivalent = 3;
	float percentageToDeemEquivalent_Exactly = 1.5f;
	float percentageToDeemEquivalent_KindOf = 6;

	public AgentVisualProblem(RavensProblem problem) {
		
	    	figA = new AgentVisualFigure(problem.getFigures().get("A"));    	
	    	figB = new AgentVisualFigure(problem.getFigures().get("B"));    	
	    	figC = new AgentVisualFigure(problem.getFigures().get("C"));    	
	    	figD = new AgentVisualFigure(problem.getFigures().get("D"));    	
	    	figE = new AgentVisualFigure(problem.getFigures().get("E"));    	
	    	figF = new AgentVisualFigure(problem.getFigures().get("F"));    	
	    	figG = new AgentVisualFigure(problem.getFigures().get("G"));    	
	    	figH = new AgentVisualFigure(problem.getFigures().get("H"));    	
	    	fig1 = new AgentVisualFigure(problem.getFigures().get("1"));    	
	    	fig2 = new AgentVisualFigure(problem.getFigures().get("2"));    	
	    	fig3 = new AgentVisualFigure(problem.getFigures().get("3"));    	
	    	fig4 = new AgentVisualFigure(problem.getFigures().get("4"));    	
	    	fig5 = new AgentVisualFigure(problem.getFigures().get("5"));    	
	    	fig6 = new AgentVisualFigure(problem.getFigures().get("6"));    	
	    	fig7 = new AgentVisualFigure(problem.getFigures().get("7"));    	
	    	fig8 = new AgentVisualFigure(problem.getFigures().get("8"));   
    	}
	
	public int isItLikeBasicD01() {
		int answer = -1;
		
		float similarityAB = figA.percentSimilarToOtherFigure(figB);
		float similarityBC = figB.percentSimilarToOtherFigure(figC);
		float similarityDE = figD.percentSimilarToOtherFigure(figE);
		float similarityEF = figE.percentSimilarToOtherFigure(figF);
		float similarityGH = figG.percentSimilarToOtherFigure(figH);
		
		if(areTheseNumbersEquivalent(similarityAB, 100, percentageToDeemEquivalent) && areTheseNumbersEquivalent(similarityBC, 100, percentageToDeemEquivalent)) { 
			//THE FIRST ROW IS VIRTUALLY THE SAME ACROSS
			if(areTheseNumbersEquivalent(similarityDE, 100, percentageToDeemEquivalent) && areTheseNumbersEquivalent(similarityEF, 100, percentageToDeemEquivalent)) { 
				//THE SECOND ROW IS VIRTUALLY THE SAME ACROSS
				if(areTheseNumbersEquivalent(similarityGH, 100, percentageToDeemEquivalent)) {
					//THE FIRST PART OF THE THIRD ROW IS VIRTUALLY THE SAME, FIND THE ANSWER WHICH WILL BE VIRTUALLY THE SAME AS WELL
					
					return getBestAnswerIndexAboveThreshold(figH,  95);
					
				}
			}
		}
			
		
		return answer;
	}

	public int isItLikeBasicD02() {
		int answer = -1;
		
		float similarityAE = figA.percentSimilarToOtherFigure(figE);
		float similarityDH = figD.percentSimilarToOtherFigure(figH);
		float similarityBF = figB.percentSimilarToOtherFigure(figF);
		
		if(areTheseNumbersEquivalent(similarityAE, 100, percentageToDeemEquivalent)) { 
			//THE DIAGONAL TOP-LEFT/BOTTOM-RIGHT ARE VIRTUALLY THE SAME 
			if(areTheseNumbersEquivalent(similarityDH, 100, percentageToDeemEquivalent) && areTheseNumbersEquivalent(similarityBF, 100, percentageToDeemEquivalent)) { 
				//THE DH AND BF DIAGONALS ARE VIRTUALLY THE SAME.  SEE IF THERE IS A MATCH TO E AMONG THE ANSWERS 
					
				return getBestAnswerIndexAboveThreshold(figE,  95);
			}
		}
			
		
		return answer;
	}
	
	public int isItLikeBasicD04() {
		int answer = -1;
		
		float similarityAB = figA.percentSimilarToOtherFigure(figB);
		float similarityDE = figD.percentSimilarToOtherFigure(figE);
		float similarityGH = figG.percentSimilarToOtherFigure(figH);
		if(areTheseNumbersEquivalent(similarityAB, similarityDE, percentageToDeemEquivalent) && areTheseNumbersEquivalent(similarityAB, similarityGH, percentageToDeemEquivalent)) {
			//DIFFERENCE BETWEEN A AND B IS SAME AS DIFFERENCE BETWEEN D AND E AND THAT OF G AND H

			float similarityBC = figB.percentSimilarToOtherFigure(figC);
			float similarityEF = figE.percentSimilarToOtherFigure(figF);
			if(areTheseNumbersEquivalent(similarityBC, similarityEF, percentageToDeemEquivalent)) {
				//DIFFERENCE BETWEEN B AND C IS SAME AS DIFFERENCE BETWEEN E AND F
				
				if(areTheseNumbersEquivalent(similarityEF, figH.percentSimilarToOtherFigure(fig1), percentageToDeemEquivalent))
					return 1;
				if(areTheseNumbersEquivalent(similarityEF, figH.percentSimilarToOtherFigure(fig2), percentageToDeemEquivalent))
					return 2;
				if(areTheseNumbersEquivalent(similarityEF, figH.percentSimilarToOtherFigure(fig3), percentageToDeemEquivalent))
					return 3;
				if(areTheseNumbersEquivalent(similarityEF, figH.percentSimilarToOtherFigure(fig4), percentageToDeemEquivalent))
					return 4;
				if(areTheseNumbersEquivalent(similarityEF, figH.percentSimilarToOtherFigure(fig5), percentageToDeemEquivalent))
					return 5;
				if(areTheseNumbersEquivalent(similarityEF, figH.percentSimilarToOtherFigure(fig6), percentageToDeemEquivalent))
					return 6;
				if(areTheseNumbersEquivalent(similarityEF, figH.percentSimilarToOtherFigure(fig7), percentageToDeemEquivalent))
					return 7;
				if(areTheseNumbersEquivalent(similarityEF, figH.percentSimilarToOtherFigure(fig8), percentageToDeemEquivalent))
					return 8;
			}			
		}
			
		
		return answer;
	}
	
	public int isItLikeBasicE06() {
		int answer = -1;
		
		AgentVisualFigure combinationOfAG = new AgentVisualFigure(figA, figG, combinationMethod.OR);
		float similarityD = combinationOfAG.percentSimilarToOtherFigure(figD);
		if(areTheseNumbersEquivalent(similarityD, 100, percentageToDeemEquivalent)) {
			//THE OR OF A AND G EQUALS D
			AgentVisualFigure combinationOfBH = new AgentVisualFigure(figB, figH, combinationMethod.OR);
			float similarityE = combinationOfBH.percentSimilarToOtherFigure(figE);
			if(areTheseNumbersEquivalent(similarityE, 100, percentageToDeemEquivalent)) {
				//THE OR OF B AND H EQUALS E
				
				//REMOVE ANY ANSWERS WHICH ARE THE SAME AS A-H
				boolean answer1 = true;
				boolean answer2 = true;
				boolean answer3 = true;
				boolean answer4 = true;
				boolean answer5 = true;
				boolean answer6 = true;
				boolean answer7 = true;
				boolean answer8 = true;
				
				if(isThisAnswerTheSameAsAnyNonAnswer(fig1, percentageToDeemEquivalent_Exactly) > -1)
					answer1 = false;
				if(isThisAnswerTheSameAsAnyNonAnswer(fig2, percentageToDeemEquivalent_Exactly) > -1)
					answer2 = false;
				if(isThisAnswerTheSameAsAnyNonAnswer(fig3, percentageToDeemEquivalent_Exactly) > -1)
					answer3 = false;
				if(isThisAnswerTheSameAsAnyNonAnswer(fig4, percentageToDeemEquivalent_Exactly) > -1)
					answer4 = false;
				if(isThisAnswerTheSameAsAnyNonAnswer(fig5, percentageToDeemEquivalent_Exactly) > -1)
					answer5 = false;
				if(isThisAnswerTheSameAsAnyNonAnswer(fig6, percentageToDeemEquivalent_Exactly) > -1)
					answer6 = false;
				if(isThisAnswerTheSameAsAnyNonAnswer(fig7, percentageToDeemEquivalent_Exactly) > -1)
					answer7 = false;
				if(isThisAnswerTheSameAsAnyNonAnswer(fig8, percentageToDeemEquivalent_Exactly) > -1)
					answer8 = false;
				

				if(answer1) {
					AgentVisualFigure combinationOf1C = new AgentVisualFigure(fig1, figC, combinationMethod.OR);
					float similarityF = combinationOf1C.percentSimilarToOtherFigure(figF);
					if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent))
						return 1;
				}
				if(answer2) {
					AgentVisualFigure combinationOf2C = new AgentVisualFigure(fig2, figC, combinationMethod.OR);
					float similarityF = combinationOf2C.percentSimilarToOtherFigure(figF);
					if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent))
						return 2;
				}
				if(answer3) {
					AgentVisualFigure combinationOf3C = new AgentVisualFigure(fig3, figC, combinationMethod.OR);
					float similarityF = combinationOf3C.percentSimilarToOtherFigure(figF);
					if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent))
						return 3;
				}
				if(answer4) {
					AgentVisualFigure combinationOf4C = new AgentVisualFigure(fig4, figC, combinationMethod.OR);
					float similarityF = combinationOf4C.percentSimilarToOtherFigure(figF);
					if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent))
						return 4;
				}
				if(answer5) {
					AgentVisualFigure combinationOf5C = new AgentVisualFigure(fig5, figC, combinationMethod.OR);
					float similarityF = combinationOf5C.percentSimilarToOtherFigure(figF);
					if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent))
						return 5;
				}
				if(answer6) {
					AgentVisualFigure combinationOf6C = new AgentVisualFigure(fig6, figC, combinationMethod.OR);
					float similarityF = combinationOf6C.percentSimilarToOtherFigure(figF);
					if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent))
						return 6;
				}
				if(answer7) {
					AgentVisualFigure combinationOf7C = new AgentVisualFigure(fig7, figC, combinationMethod.OR);
					float similarityF = combinationOf7C.percentSimilarToOtherFigure(figF);
					if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent))
						return 7;
				}
				if(answer8) {
					AgentVisualFigure combinationOf8C = new AgentVisualFigure(fig8, figC, combinationMethod.OR);
					float similarityF = combinationOf8C.percentSimilarToOtherFigure(figF);
					if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent))
						return 8;
				}
			}		
		}		
		
		return answer;
	}
		
	public int isItLikeBasicE05() {
		int answer = -1;
		
		AgentVisualFigure combinationOfAD = new AgentVisualFigure(figA, figD, combinationMethod.XOR);
		float similarityG = combinationOfAD.percentSimilarToOtherFigure(figG);
		if(areTheseNumbersEquivalent(similarityG, 100, percentageToDeemEquivalent)) {
			//THE XOR OF A AND D EQUALS G
			AgentVisualFigure combinationOfBE = new AgentVisualFigure(figB, figE, combinationMethod.XOR);
			float similarityH = combinationOfBE.percentSimilarToOtherFigure(figH);
			if(areTheseNumbersEquivalent(similarityH, 100, percentageToDeemEquivalent)) {
				//THE XOR OF B AND E EQUALS H

				AgentVisualFigure combinationOfCF = new AgentVisualFigure(figC, figF, combinationMethod.XOR);
				float similarity1 = combinationOfCF.percentSimilarToOtherFigure(fig1);
				if(areTheseNumbersEquivalent(similarity1, 100, percentageToDeemEquivalent))
					return 1;
				float similarity2 = combinationOfCF.percentSimilarToOtherFigure(fig2);
				if(areTheseNumbersEquivalent(similarity2, 100, percentageToDeemEquivalent))
					return 2;
				float similarity3 = combinationOfCF.percentSimilarToOtherFigure(fig3);
				if(areTheseNumbersEquivalent(similarity3, 100, percentageToDeemEquivalent))
					return 3;
				float similarity4 = combinationOfCF.percentSimilarToOtherFigure(fig4);
				if(areTheseNumbersEquivalent(similarity4, 100, percentageToDeemEquivalent))
					return 4;
				float similarity5 = combinationOfCF.percentSimilarToOtherFigure(fig5);
				if(areTheseNumbersEquivalent(similarity5, 100, percentageToDeemEquivalent))
					return 5;
				float similarity6 = combinationOfCF.percentSimilarToOtherFigure(fig6);
				if(areTheseNumbersEquivalent(similarity6, 100, percentageToDeemEquivalent))
					return 6;
				float similarity7 = combinationOfCF.percentSimilarToOtherFigure(fig7);
				if(areTheseNumbersEquivalent(similarity7, 100, percentageToDeemEquivalent))
					return 7;
				float similarity8 = combinationOfCF.percentSimilarToOtherFigure(fig8);
				if(areTheseNumbersEquivalent(similarity8, 100, percentageToDeemEquivalent))
					return 8;
					

			}
		}
		
		return answer;
	}
	
	public int isItLikeBasicE03() {
		int answer = -1;
		
		AgentVisualFigure combinationOfAB = new AgentVisualFigure(figA, figB, combinationMethod.OR);
		float similarityC = combinationOfAB.percentSimilarToOtherFigure(figC);
		
		if(areTheseNumbersEquivalent(similarityC, 100, percentageToDeemEquivalent)) {
			//COMBO OF A AND B IS EQUIVALENT TO C
			
			AgentVisualFigure combinationOfDE = new AgentVisualFigure(figD, figE, combinationMethod.OR);
			float similarityF = combinationOfDE.percentSimilarToOtherFigure(figF);
			
			if(areTheseNumbersEquivalent(similarityF, 100, percentageToDeemEquivalent)) {
				//COMBO OF D AND E IS EQUIVALENT TO F

				AgentVisualFigure combinationOfAD = new AgentVisualFigure(figA, figD, combinationMethod.OR);
				float similarityG = combinationOfAD.percentSimilarToOtherFigure(figG);
				
				if(areTheseNumbersEquivalent(similarityG, 100, percentageToDeemEquivalent)) {
					//COMBO OF A AND D IS EQUIVALENT TO G

					AgentVisualFigure combinationOfBE = new AgentVisualFigure(figB, figE, combinationMethod.OR);
					float similarityH = combinationOfBE.percentSimilarToOtherFigure(figH);
					
					if(areTheseNumbersEquivalent(similarityH, 100, percentageToDeemEquivalent)) {
						//COMBO OF B AND E IS EQUIVALENT TO H
						
						AgentVisualFigure combinationOfCF = new AgentVisualFigure(figC, figF, combinationMethod.OR);
						AgentVisualFigure combinationOfGH = new AgentVisualFigure(figG, figH, combinationMethod.OR);
						
						float combinedSimilarity1 = combinationOfCF.percentSimilarToOtherFigure(fig1);
						combinedSimilarity1 += combinationOfGH.percentSimilarToOtherFigure(fig1);
						float combinedSimilarity2 = combinationOfCF.percentSimilarToOtherFigure(fig2);
						combinedSimilarity2 += combinationOfGH.percentSimilarToOtherFigure(fig2);
						float combinedSimilarity3 = combinationOfCF.percentSimilarToOtherFigure(fig3);
						combinedSimilarity3 += combinationOfGH.percentSimilarToOtherFigure(fig3);
						float combinedSimilarity4 = combinationOfCF.percentSimilarToOtherFigure(fig4);
						combinedSimilarity4 += combinationOfGH.percentSimilarToOtherFigure(fig4);
						float combinedSimilarity5 = combinationOfCF.percentSimilarToOtherFigure(fig5);
						combinedSimilarity5 += combinationOfGH.percentSimilarToOtherFigure(fig5);
						float combinedSimilarity6 = combinationOfCF.percentSimilarToOtherFigure(fig6);
						combinedSimilarity6 += combinationOfGH.percentSimilarToOtherFigure(fig6);
						float combinedSimilarity7 = combinationOfCF.percentSimilarToOtherFigure(fig7);
						combinedSimilarity7 += combinationOfGH.percentSimilarToOtherFigure(fig7);
						float combinedSimilarity8 = combinationOfCF.percentSimilarToOtherFigure(fig8);
						combinedSimilarity8 += combinationOfGH.percentSimilarToOtherFigure(fig8);

						int bestIndex = 1;
						float bestVal = combinedSimilarity1;
						
						if(combinedSimilarity2 > bestVal) {
							bestVal = combinedSimilarity2;
							bestIndex = 2;
						}
						if(combinedSimilarity3 > bestVal) {
							bestVal = combinedSimilarity3;
							bestIndex = 3;
						}
						if(combinedSimilarity4 > bestVal) {
							bestVal = combinedSimilarity4;
							bestIndex = 4;
						}
						if(combinedSimilarity5 > bestVal) {
							bestVal = combinedSimilarity5;
							bestIndex = 5;
						}
						if(combinedSimilarity6 > bestVal) {
							bestVal = combinedSimilarity6;
							bestIndex = 6;
						}
						if(combinedSimilarity7 > bestVal) {
							bestVal = combinedSimilarity7;
							bestIndex = 7;
						}
						if(combinedSimilarity8 > bestVal) {
							bestVal = combinedSimilarity8;
							bestIndex = 8;
						}
							
						if(areTheseNumbersEquivalent(bestVal, 200, percentageToDeemEquivalent))
							return bestIndex;
						
					}
				}
			}
		}
		
		return answer;
	}
	
	/*
	 * THIS IS A LAST RESORT ONE. I'M NOT SURE WHAT THE ANSWERS ARE REALLY EVEN ABOUT
	 * BUT I'M GOING TO SAY THAT IF A AND E ARE DIFFERENT THEN FIND AN ANSWER WHICH IS 
	 * NOT THE SAME AS A AND NOT THE SAME AS E AND HAS A SIGNIFICANTLY SIMILAR DIFFERENCE 
	 * BETWEEN E AND ITSELF TO THAT OF A AND E
	 */
	public int isItLikeBasicD07() {
		int answer = -1;
		
		float similarityAB = figA.percentSimilarToOtherFigure(figB);
		float similarityBC = figB.percentSimilarToOtherFigure(figC);
		float similarityAD = figA.percentSimilarToOtherFigure(figD);
		float similarityDG = figD.percentSimilarToOtherFigure(figG);
		float similarityAE = figA.percentSimilarToOtherFigure(figE);
		if(!areTheseNumbersEquivalent(similarityAB, 100, percentageToDeemEquivalent) &&
				!areTheseNumbersEquivalent(similarityBC, 100, percentageToDeemEquivalent) &&
				!areTheseNumbersEquivalent(similarityAD, 100, percentageToDeemEquivalent) &&
				!areTheseNumbersEquivalent(similarityDG, 100, percentageToDeemEquivalent) &&
				!areTheseNumbersEquivalent(similarityAE, 100, percentageToDeemEquivalent)) {

			boolean answer1 = true;
			boolean answer2 = true;
			boolean answer3 = true;
			boolean answer4 = true;
			boolean answer5 = true;
			boolean answer6 = true;
			boolean answer7 = true;
			boolean answer8 = true;
			
			//NOT MUCH IS SIMILAR ANYWHERE HERE SO ELIMINATE ANYTHING THAT'S TOO SIMILAR TO E
			float similarityE1 = figE.percentSimilarToOtherFigure(fig1);
			float similarityE2 = figE.percentSimilarToOtherFigure(fig2);
			float similarityE3 = figE.percentSimilarToOtherFigure(fig3);
			float similarityE4 = figE.percentSimilarToOtherFigure(fig4);
			float similarityE5 = figE.percentSimilarToOtherFigure(fig5);
			float similarityE6 = figE.percentSimilarToOtherFigure(fig6);
			float similarityE7 = figE.percentSimilarToOtherFigure(fig7);
			float similarityE8 = figE.percentSimilarToOtherFigure(fig8);

			if(areTheseNumbersEquivalent(similarityE1, 100, percentageToDeemEquivalent))
				answer1 = false;
			if(areTheseNumbersEquivalent(similarityE2, 100, percentageToDeemEquivalent))
				answer2 = false;
			if(areTheseNumbersEquivalent(similarityE3, 100, percentageToDeemEquivalent))
				answer3 = false;
			if(areTheseNumbersEquivalent(similarityE4, 100, percentageToDeemEquivalent))
				answer4 = false;
			if(areTheseNumbersEquivalent(similarityE5, 100, percentageToDeemEquivalent))
				answer5 = false;
			if(areTheseNumbersEquivalent(similarityE6, 100, percentageToDeemEquivalent))
				answer6 = false;
			if(areTheseNumbersEquivalent(similarityE7, 100, percentageToDeemEquivalent))
				answer7 = false;
			if(areTheseNumbersEquivalent(similarityE8, 100, percentageToDeemEquivalent))
				answer8 = false;

			float similarityA1 = -1000;
			float similarityA2 = -1000;
			float similarityA3 = -1000;
			float similarityA4 = -1000;
			float similarityA5 = -1000;
			float similarityA6 = -1000;
			float similarityA7 = -1000;
			float similarityA8 = -1000;
			
			//NOT MUCH IS SIMILAR ANYWHERE HERE SO ELIMINATE ANYTHING THAT'S TOO SIMILAR TO A
			if(answer1) {
				similarityA1 = figA.percentSimilarToOtherFigure(fig1);
				if(areTheseNumbersEquivalent(similarityA1, 100, percentageToDeemEquivalent))
					answer1 = false;
			}
			if(answer2) {
				similarityA2 = figA.percentSimilarToOtherFigure(fig2);
				if(areTheseNumbersEquivalent(similarityA2, 100, percentageToDeemEquivalent))
					answer2 = false;
			}				
			if(answer3) {
				similarityA3 = figA.percentSimilarToOtherFigure(fig3);
				if(areTheseNumbersEquivalent(similarityA3, 100, percentageToDeemEquivalent))
					answer3 = false;
			}				
			if(answer4) {
				similarityA4 = figA.percentSimilarToOtherFigure(fig4);
				if(areTheseNumbersEquivalent(similarityA4, 100, percentageToDeemEquivalent))
					answer4 = false;
			}				
			if(answer5) {
				similarityA5 = figA.percentSimilarToOtherFigure(fig5);
				if(areTheseNumbersEquivalent(similarityA5, 100, percentageToDeemEquivalent))
					answer5 = false;
			}				
			if(answer6) {
				similarityA6 = figA.percentSimilarToOtherFigure(fig6);
				if(areTheseNumbersEquivalent(similarityA6, 100, percentageToDeemEquivalent))
					answer6 = false;
			}				
			if(answer7) {
				similarityA7 = figA.percentSimilarToOtherFigure(fig7);
				if(areTheseNumbersEquivalent(similarityA7, 100, percentageToDeemEquivalent))
					answer7 = false;
			}				
			if(answer8) {
				similarityA8 = figA.percentSimilarToOtherFigure(fig8);
				if(areTheseNumbersEquivalent(similarityA8, 100, percentageToDeemEquivalent))
					answer8 = false;
			}				

			
			//NOW ELIMINATE ANYTHING THAT IS JUST LIKE ANYTHING A-H
			if(answer1 && isThisAnswerTheSameAsAnyNonAnswer(fig1, percentageToDeemEquivalent_Exactly) > -1)
					answer1 = false;
			if(answer2 && isThisAnswerTheSameAsAnyNonAnswer(fig2, percentageToDeemEquivalent_Exactly) > -1)
					answer2 = false;
			if(answer3 && isThisAnswerTheSameAsAnyNonAnswer(fig3, percentageToDeemEquivalent_Exactly) > -1)
					answer3 = false;
			if(answer4 && isThisAnswerTheSameAsAnyNonAnswer(fig4, percentageToDeemEquivalent_Exactly) > -1)
					answer4 = false;
			if(answer5 && isThisAnswerTheSameAsAnyNonAnswer(fig5, percentageToDeemEquivalent_Exactly) > -1)
					answer5 = false;
			if(answer6 && isThisAnswerTheSameAsAnyNonAnswer(fig6, percentageToDeemEquivalent_Exactly) > -1)
					answer6 = false;
			if(answer7 && isThisAnswerTheSameAsAnyNonAnswer(fig7, percentageToDeemEquivalent_Exactly) > -1)
					answer7 = false;
			if(answer8 && isThisAnswerTheSameAsAnyNonAnswer(fig8, percentageToDeemEquivalent_Exactly) > -1)
					answer8 = false;
			

			//NOW FIND THE ANSWER WHICH HAS THE DIFFERENCE TO E WHICH IS MOST CLOSE TO THE DIFFERENCE BETWEEN A AND E 
			int bestIndex = -1;
			float bestVal = -1000;

			if(answer1 && Math.abs((similarityE1 + similarityA1) - (similarityAE * 2)) < Math.abs(bestVal - (similarityAE * 2))) {
				bestIndex = 1;
				bestVal = similarityE1 + similarityA1;
			}
			if(answer2 && Math.abs((similarityE2 + similarityA2) - (similarityAE * 2)) < Math.abs(bestVal - (similarityAE * 2))) {
				bestIndex = 2;
				bestVal = similarityE2 + similarityA2;
			}
			if(answer3 && Math.abs((similarityE3 + similarityA3) - (similarityAE * 2)) < Math.abs(bestVal - (similarityAE * 2))) {
				bestIndex = 3;
				bestVal = similarityE3 + similarityA3;
			}
			if(answer4 && Math.abs((similarityE4 + similarityA4) - (similarityAE * 2)) < Math.abs(bestVal - (similarityAE * 2))) {
				bestIndex = 4;
				bestVal = similarityE4 + similarityA4;
			}
			if(answer5 && Math.abs((similarityE5 + similarityA5) - (similarityAE * 2)) < Math.abs(bestVal - (similarityAE * 2))) {
				bestIndex = 5;
				bestVal = similarityE5 + similarityA5;
			}
			if(answer6 && Math.abs((similarityE6 + similarityA6) - (similarityAE * 2)) < Math.abs(bestVal - (similarityAE * 2))) {
				bestIndex = 6;
				bestVal = similarityE6 + similarityA6;
			}
			if(answer7 && Math.abs((similarityE7 + similarityA7) - (similarityAE * 2)) < Math.abs(bestVal - (similarityAE * 2))) {
				bestIndex = 7;
				bestVal = similarityE7 + similarityA7;
			}
			if(answer8 && Math.abs((similarityE8 + similarityA8) - (similarityAE * 2)) < Math.abs(bestVal - (similarityAE * 2))) {
				bestIndex = 8;
				bestVal = similarityE8 + similarityA8;
			}
				
			
			
			//NOW SEE IF THE NUMBER OF THE BEST ANSWER IS CLOSE ENOUGH TO THE DIFF BETWEEN A AND E TO COUNT
			if(areTheseNumbersEquivalent(bestVal, similarityAE * 2, percentageToDeemEquivalent_KindOf))
				return bestIndex;
			
		}
		
		
		return answer;
	}
	
	public int isThisAnswerTheSameAsAnyNonAnswer(AgentVisualFigure answer, float percentage) {
		
		if(areTheseNumbersEquivalent(answer.percentSimilarToOtherFigure(figA),  100,  percentage))
			return 1; 
		if(areTheseNumbersEquivalent(answer.percentSimilarToOtherFigure(figB),  100,  percentage))
			return 2; 
		if(areTheseNumbersEquivalent(answer.percentSimilarToOtherFigure(figC),  100,  percentage))
			return 3; 
		if(areTheseNumbersEquivalent(answer.percentSimilarToOtherFigure(figD),  100,  percentage))
			return 4; 
		if(areTheseNumbersEquivalent(answer.percentSimilarToOtherFigure(figE),  100,  percentage))
			return 5; 
		if(areTheseNumbersEquivalent(answer.percentSimilarToOtherFigure(figF),  100,  percentage))
			return 6; 
		if(areTheseNumbersEquivalent(answer.percentSimilarToOtherFigure(figG),  100,  percentage))
			return 7; 
		if(areTheseNumbersEquivalent(answer.percentSimilarToOtherFigure(figH),  100,  percentage))
			return 8; 
		
		return -1;
	}
	
	public boolean areTheseNumbersEquivalent(float a, float b, float percentage) {
		float percent = (float)percentage / 100;
		
		float min = (float)b * (1 - percent);
		float max = (float)b * (1 + percent);
		
		if(a >= min && a <= max)
			return true;
		
		return false;
	}
	
	public int getBestAnswerIndexAboveThreshold(AgentVisualFigure figure, int threshold) {
		int index = -1;
		float highestPercentage = -1;
		
		
		float temp = fig1.percentSimilarToOtherFigure(figure);
		if(temp >= threshold) {
			index = 1;
			highestPercentage = temp;
		}
			
		temp = fig2.percentSimilarToOtherFigure(figure);
		if(temp >= threshold && temp > highestPercentage) {
			index = 2;
			highestPercentage = temp;
		}
			
		temp = fig3.percentSimilarToOtherFigure(figure);
		if(temp >= threshold && temp > highestPercentage) {
			index = 3;
			highestPercentage = temp;
		}

		temp = fig4.percentSimilarToOtherFigure(figure);
		if(temp >= threshold && temp > highestPercentage) {
			index = 4;
			highestPercentage = temp;
		}

		temp = fig5.percentSimilarToOtherFigure(figure);
		if(temp >= threshold && temp > highestPercentage) {
			index = 5;
			highestPercentage = temp;
		}

		temp = fig6.percentSimilarToOtherFigure(figure);
		if(temp >= threshold && temp > highestPercentage) {
			index = 6;
			highestPercentage = temp;
		}

		temp = fig7.percentSimilarToOtherFigure(figure);
		if(temp >= threshold && temp > highestPercentage) {
			index = 7;
			highestPercentage = temp;
		}

		temp = fig8.percentSimilarToOtherFigure(figure);
		if(temp >= threshold && temp > highestPercentage) {
			index = 8;
			highestPercentage = temp;
		}

		return index;
	}

}