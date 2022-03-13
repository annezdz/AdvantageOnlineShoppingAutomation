package entities;

public class Produto {
	
	
		private int idMassas;

		private String nameProduct;

		private String customization;

		private String display;

		private String displayResolution;

		private String displaySize;

		private String memory;

		private String operatingSystem;

		private String processor;

		private String touchscreen;

		private String weight;

		private String color;

		public Produto() {
		}

		public Produto(int idMassas,
					   String nameProduct,
					   String customization,
					   String display,
					   String displayResolution,
					   String displaySize,
					   String memory,
					   String operatingSystem,
					   String processor,
					   String touchscreen,
					   String weight,
					   String color) {
			this.idMassas = idMassas;
			this.nameProduct = nameProduct;
			this.customization = customization;
			this.display = display;
			this.displayResolution = displayResolution;
			this.displaySize = displaySize;
			this.memory = memory;
			this.operatingSystem = operatingSystem;
			this.processor = processor;
			this.touchscreen = touchscreen;
			this.weight = weight;
			this.color = color;
		}

		public int getIdMassas() {
			return idMassas;
		}

		public String getNameProduct() {
			return nameProduct;
		}

		public String getCustomization() {
			return customization;
		}

		public String getDisplay() {
			return display;
		}

		public String getDisplayResolution() {
			return displayResolution;
		}

		public String getDisplaySize() {
			return displaySize;
		}

		public String getMemory() {
			return memory;
		}

		public String getOperatingSystem() {
			return operatingSystem;
		}

		public String getProcessor() {
			return processor;
		}

		public String getTouchscreen() {
			return touchscreen;
		}

		public String getWeight() {
			return weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}


}
