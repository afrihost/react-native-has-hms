require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-has-hms"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  react-native-has-hms
                   DESC
  s.homepage     = "https://github.com/afrihost/react-native-has-hms"
  # s.license      = "MIT"
  s.license    = { :type => "MIT", :file => "LICENSE" }
  s.authors      = { "Afrihost" => "open-source@afrihost.com" }
  s.platforms    = { :ios => "9.0" }
  s.source       = { :git => "https://github.com/afrihost/react-native-has-hms.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m,swift}"
  s.requires_arc = true

  s.dependency "React"
  # ...
  # s.dependency "..."
end

