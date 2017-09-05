import React, {Component} from 'react';
import {
    StyleSheet,
    Text,
    View,
    Navigator,
    ListView,
    TouchableHighlight,
    TouchableOpacity,
    AppRegistry,
    ToastAndroid,
    NativeModules,
    DeviceEventEmitter
} from 'react-native';

export default class ReactDemo extends Component {

   constructor(props) {
           super(props);

   }

   componentDidMount()
   {
       DeviceEventEmitter.addListener('qqq',(str)=>{
           ToastAndroid.show(str,ToastAndroid.SHORT);
            console.log(str);
       })

   }
    skipNativeCall()
    {
        NativeModules.commModule.rnCallNative('15332411286');
    }

    promiseCall()
    {
        NativeModules.commModule.callPromise('qqq').then((aaa)=>{
            ToastAndroid.show(aaa,ToastAndroid.SHORT);


        });
    }
       render() {
           return (

               <View style={{paddingBottom:55}}>
                   <Text onPress={this.promiseCall.bind(this)} style={{fontSize:50}}> qwe </Text>

               </View>
           );
       }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'black',
    }
});
AppRegistry.registerComponent('ReactDemo', () =>ReactDemo );