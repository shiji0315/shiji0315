import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '服装类型id',
    align:"center",
    dataIndex: 'clothsTypeId'
   },
   {
    title: '款式id',
    align:"center",
    dataIndex: 'styleId'
   },
   {
    title: '模块id',
    align:"center",
    dataIndex: 'modularId'
   },
   {
    title: '创建时间',
    align:"center",
    dataIndex: 'createTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '服装类型id',
    field: 'clothsTypeId',
    component: 'Input',
  },
  {
    label: '款式id',
    field: 'styleId',
    component: 'Input',
  },
  {
    label: '模块id',
    field: 'modularId',
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