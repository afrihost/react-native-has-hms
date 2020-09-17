declare module 'react-native-has-hms' {
    class Module {
        static isGMSAvailable(): Promise<boolean>
        static isHMSAvailable(): Promise<boolean>
    }

    export default Module
}
