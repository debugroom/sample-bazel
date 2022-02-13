# load our Spring Boot rule
load("@rules_spring//springboot:springboot.bzl", "springboot")

# create our deps list for Spring Boot
springboot_deps = [
    "@rules_spring//springboot/import_bundles:springboot_required_deps",
    "@maven//:org_springframework_boot_spring_boot_starter_jetty",
    "@maven//:org_springframework_boot_spring_boot_starter_web",
    "@maven//:org_springframework_spring_webmvc",

]

# This Java library contains the app code
java_library(
    name = "sample_bazel_springboot_lib",
    srcs = glob(["src/main/java/**/*.java"]),
    resources = glob(["src/main/resources/**"]),
    deps = springboot_deps,
)

# Build the app as a Spring Boot executable jar
springboot(
    name = "sample_bazel_springboot",
    boot_app_class = "org.debugroom.sample.bazel.springboot.config.App",
    java_library = ":sample_bazel_springboot_lib",
)

load("@io_bazel_rules_docker//container:image.bzl", "container_image")


container_image(
    name = "sample_bazel_springboot_img",
    # References container_pull from WORKSPACE (above)
    base = "@java_base//image",
    files = ["//:sample_bazel_springboot.jar"],
    cmd = ["sample_bazel_springboot.jar"]
)