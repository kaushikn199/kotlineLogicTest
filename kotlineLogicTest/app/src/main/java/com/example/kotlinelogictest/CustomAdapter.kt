package com.example.kotlinelogictest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ItemModel>, val columns: Int) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //val itemsModel = mList[position]

        holder.view.setOnClickListener {
            /*mList[position].color = R.color.red
            mList[position].selector = position;
            notifyItemChanged(position)*/

            // Calculate row and column of the selected position
            var row = position / columns;
            var column = position % columns;

            // Get all indices in the same row
            var rowStart = row * columns;
            for (i in 0 until columns) {
                mList[rowStart + i].color = R.color.red
                mList[rowStart + i].selector = rowStart + i;
                notifyItemChanged(rowStart + i)
            }

            for (i in 0 until columns) {
                mList[i * columns + column].color = R.color.red
                mList[i * columns + column].selector = i * columns + column;
                notifyItemChanged(i * columns + column)
            }

            // Calculate main diagonal (from top-left to bottom-right) passing through the position
            var startRow = row;
            var startCol = column;

            // Move to the top-left starting point of the diagonal
            while (startRow > 0 && startCol > 0) {
                startRow--;
                startCol--;
            }

            // Traverse from top-left to bottom-right for main diagonal
            var tempRow = startRow;
            var tempCol = startCol;
            while (tempRow < columns && tempCol < columns) {


                mList[tempRow * columns + tempCol].color = R.color.red
                mList[tempRow * columns + tempCol].selector = tempRow * columns + tempCol;
                notifyItemChanged(tempRow * columns + tempCol)


                tempRow++;
                tempCol++;
            }

            // Calculate anti-diagonal (from bottom-left to top-right) passing through the position
            startRow = row;
            startCol = column;

            // Move to the bottom-left starting point of the anti-diagonal
            while (startRow < columns - 1 && startCol > 0) {
                startRow++;
                startCol--;
            }

            // Traverse from bottom-left to top-right for anti-diagonal
            tempRow = startRow;
            tempCol = startCol;
            while (tempRow >= 0 && tempCol < columns) {
                //antiDiagonal.add(tempRow * columns + tempCol);
                mList[tempRow * columns + tempCol].color = R.color.red
                mList[tempRow * columns + tempCol].selector = tempRow * columns + tempCol;
                notifyItemChanged(tempRow * columns + tempCol)
                tempRow--;
                tempCol++;
            }



        }

        if (mList[position].selector == position) {
            holder.view.setBackgroundColor(holder.view.context.getColor(R.color.red))
        }



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        // val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val view: View = itemView.findViewById(R.id.view)
    }
}