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
    NativeModules
} from 'react-native';

export default class ReactDemo extends Component {

   constructor(props) {
           super(props);

       }
    skipNativeCall()
    {
        NativeModules.CommnMoudle.rnCallNative('15332411286');
    }
       render() {
           return (

               <View style={{paddingBottom:55}}>
                   <Text onPress={this.skipNativeCall.bind(this)} style={{fontSize:50}}> qwe </Text>

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