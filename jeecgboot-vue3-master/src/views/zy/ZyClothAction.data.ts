import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '频率',
    align:"center",
    dataIndex: 'freq'
   },
   {
    title: '描述',
    align:"center",
    dataIndex: 'descr'
   },
   {
    title: '设备TMU',
    align:"center",
    dataIndex: 'machineTmu'
   },
   {
    title: '手工TMU',
    align:"center",
    dataIndex: 'manualTmu'
   },
   {
    title: '图片',
    align:"center",
    dataIndex: 'image'
   },
   {
    title: '视频',
    align:"center",
    dataIndex: 'vedio'
   },
   {
    title: '编号',
    align:"center",
    dataIndex: 'nums'
   },
   {
    title: '创建人',
    align:"center",
    dataIndex: 'createBy'
   },
   {
    title: '创建时间',
    align:"center",
    dataIndex: 'createTime'
   },
   {
    title: '更新人',
    align:"center",
    dataIndex: 'updateBy'
   },
   {
    title: '更新时间',
    align:"center",
    dataIndex: 'updateTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '频率',
    field: 'freq',
    component: 'InputNumber',
  },
  {
    label: '描述',
    field: 'descr',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入描述!'},
          ];
     },
  },
  {
    label: '设备TMU',
    field: 'machineTmu',
    component: 'InputNumber',
  },
  {
    label: '手工TMU',
    field: 'manualTmu',
    component: 'InputNumber',
  },
  {
    label: '图片',
    field: 'image',
    component: 'Input',
  },
  {
    label: '视频',
    field: 'vedio',
    component: 'Input',
  },
  {
    label: '编号',
    field: 'nums',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入编号!'},
          ];
     },
  },
  {
    label: '创建人',
    field: 'createBy',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '更新人',
    field: 'updateBy',
    component: 'Input',
  },
  {
    label: '更新时间',
    field: 'updateTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];



/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}