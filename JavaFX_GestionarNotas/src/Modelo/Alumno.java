package Modelo;

import vista.ControladorVista1;

public class Alumno {
		private ControladorVista1 controlVista1;
		private String name;
		private String lastName;
		private String media;

		public Alumno() {
		}

		public Alumno(String name, String lastName, String media) {
			this.name = name;
			this.lastName = lastName;
			this.media = media;

		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public ControladorVista1 getConVis() {
			return controlVista1;
		}

		public void setConVis(ControladorVista1 conVis) {
			this.controlVista1 = conVis;
		}

		public String getMedia() {
			return media;
		}

		public void setMedia(String media) {
			this.media = media;
		}

	}


