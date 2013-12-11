package com.jacky.utilities;

import com.jacky.compass.Constant;

public class MathTool {
	public static String getCurrentOrientation(float angle){
		String result="";
		if(
				((359 - Constant.differ) <= angle  &&  angle <= 359) ||
				angle <= (Constant.North + Constant.differ))
			result = "北";
		else if(
				(Constant.NorthEast - Constant.differ) <= angle  &&
				angle <= (Constant.NorthEast + Constant.differ)
				)
			result = "东北";
		else if(
				(Constant.East - Constant.differ) <= angle  &&
				angle <= (Constant.East + Constant.differ)
				)
			result = "东";
		else if(
				(Constant.SouthEast - Constant.differ) <= angle  &&
				angle <= (Constant.SouthEast + Constant.differ)
				)
			result="东南";
		else if(
				(Constant.South - Constant.differ) <= angle  &&
				angle <= (Constant.South + Constant.differ)
				)
			result="南";
		else if(
				(Constant.SouthWest - Constant.differ) <= angle  &&
				angle <= (Constant.SouthWest + Constant.differ)
				)
			result="西南";
		else if(
				(Constant.West - Constant.differ) <= angle  &&
				angle <= (Constant.West + Constant.differ)
				)
			result="西";
		else if(
				(Constant.NorthWest - Constant.differ) <= angle  &&
				angle <= (Constant.NorthWest + Constant.differ)
				)
			result = "西北";
		
		return result;
	}
}
