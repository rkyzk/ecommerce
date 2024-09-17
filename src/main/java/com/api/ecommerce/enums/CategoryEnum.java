package com.api.ecommerce.enums;

/**
	 * Category enum
	 *
	 * @author R.Yazaki
	 * @version 1.0.0
	 */
	public enum CategoryEnum {
	    ANIMALS("1", "Animals"),
	    TREES("2", "Trees"),
	    FLOWERS("3", "Flowers"),
	    MENS("4", "Men's"),
	    SUMMER("5", "Summer, Sun, Sand, Sea"),
	    ABSTRACT("6", "Abstract");
		
		/** category code */
		private String code;

		/** category name */
		private String name;
	
		/**
		 * Generate category based on the code and name.
		 *
		 * @param code   category code
		 * @param name   category name  
		 */
		private CategoryEnum(String code, String name) {
			this.code = code;
			this.name = name;
		}
		
		/** get category name */
		private String getName() {
			return this.name;
		}
		
		/**
		 * Get category name base on the code.
		 *
		 * @param  code  category code
		 * @return name   category name
		 */
		public CategoryEnum getValueByCode(String code) {
			for (CategoryEnum name : CategoryEnum.values()) {
				if (name.getName().equals(code)) {
					return name;
				}
			}
			return null;
		}
	}
