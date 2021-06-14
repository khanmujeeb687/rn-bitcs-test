import React from 'react';
import {requireNativeComponent} from 'react-native';

export class ReactViewPager extends React.Component {
  onVideoChange = (data: any) => {};
  render() {
    return (
      <NativePageView
        {...this.props}
        {...{onVideoChange: this.onVideoChange}}
      />
    );
  }
}

const NativePageView = requireNativeComponent('ReactViewPager');
