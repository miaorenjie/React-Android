import React, {Component} from 'react';
import {
    StyleSheet,
    Text,
    View,
    Navigator,
    ListView,
    TouchableHighlight,
    TouchableOpacity,
    AppRegistry
} from 'react-native';

export default class ReactDemo extends Component {

   constructor(props) {
           super(props);
           var list=new Array();
           for(var i=0;i<10;i++)
           {
               person=new Object();
               person.name="asd";
               person.age=i*100;
               list.push(person);
           }
           const dataSource = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
           this.state = {
               dataSource: dataSource.cloneWithRows(list),

           }
       }

       _renderSeperator(sectionID: number, rowID: number, adjacentRowHighlighted: bool) {
           return (

               <View
                   style={{
                       height: 4,
                       backgroundColor: 'red',
                   }}
               />
           );
       }
       _renderRow(rowData,sectionId,rowID){
           return(
               <TouchableOpacity>
                   <Text style={{fontSize:60,borderWidth:1,borderColor:'black'}}>
                       {rowData.age}
                   </Text>
               </TouchableOpacity>

           )
       }

       changeListViewData(){
           var list=new Array();
           for(var i=0;i<10;i++)
           {
               person=new Object();
               person.name="asd";
               person.age=i*10;
               list.push(person);
           }
           console.log(this);
           this.setState({
              dataSource:this.state.dataSource.cloneWithRows(list)
          })
       }
       render() {
           return (

               <View style={{paddingBottom:55}}>
                   <Text onPress={this.changeListViewData.bind(this)} style={{fontSize:50}}> 111 </Text>

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