terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "3.0.1"
    }
  }
}


provider "docker" {}

resource "docker_image" "spring_boot_image" {
  name = "brightedem/app:latest"
}

resource "docker_container" "spring_boot_image" {
  name  = "bright_app"
  image = docker_image.spring_boot_image.image_id
  ports {
    internal = 8081
    external = 8081
  }
}
